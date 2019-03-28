package yasmin.ayman.alzainy.notewithdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private static final String NOTES = "notes";
    private Button cancleBtn, saveInternalBTN, loadInternalBTN, saveSqlBTN, loadSqlBTN;
    private TextView titleText, bodyText;
    private NoteAdapter noteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        noteAdapter = new NoteAdapter(SecondActivity.this);


        cancleBtn = findViewById(R.id.cancleBtnSecond);
        saveInternalBTN = findViewById(R.id.saveInternalBTN);
        saveSqlBTN = findViewById(R.id.saveSqlBTN);
        loadInternalBTN = findViewById(R.id.loadnternalBTN);
        loadSqlBTN = findViewById(R.id.loadSqlBTN);

        titleText = findViewById(R.id.titleShow);
        bodyText = findViewById(R.id.bodyShow);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        String body = intent.getStringExtra(MainActivity.BODY);
        final String title = intent.getStringExtra(MainActivity.TITLE);
        titleText.setText(title);
        bodyText.setText(body);

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveInternalBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileOutputStream noteStream = openFileOutput(NOTES, MODE_PRIVATE);
                    noteStream.write(bodyText.getText().toString().getBytes());
                    noteStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        loadInternalBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                String title = intent.getStringExtra(MainActivity.TITLE);

                try {
                    FileInputStream noteStream = openFileInput(NOTES);
                    byte[] noteBody = new byte[1024];
                    noteStream.read(noteBody);
                    noteStream.close();
                    bodyText.setText(new String(noteBody));
                    titleText.setText(title);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        saveSqlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteAdapter.insert(titleText.getText().toString(), bodyText.getText().toString());


            }
        });

        loadSqlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bodyText.setText(noteAdapter.retrieve(titleText.getText().toString()));
            }
        });

    }
}
