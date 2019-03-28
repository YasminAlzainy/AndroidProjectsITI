package yasmin.ayman.alzainy.myfirebase;

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

public class ConfirmNoteActivity extends AppCompatActivity {

    private static final String NOTES = "notes";
    private Button btnRealTimeDB;
    private TextView titleText, bodyText;

    public static final String TITLE_KEY = "title";
    public static final String BODY_KEY = "body";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_note);

        titleText = findViewById(R.id.titleShow);
        bodyText = findViewById(R.id.bodyShow);
        btnRealTimeDB = findViewById(R.id.btnViewRealTimeDB);

        Intent intent = getIntent();
        titleText.setText(intent.getStringExtra(NoteActivity.TITLE));
        bodyText.setText(intent.getStringExtra(NoteActivity.BODY));


        btnRealTimeDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent firebaseDBIntent = new Intent(ConfirmNoteActivity.this, RealTimeDB.class);
                firebaseDBIntent.putExtra(TITLE_KEY, titleText.getText().toString());
                firebaseDBIntent.putExtra(BODY_KEY, bodyText.getText().toString());
                startActivity(firebaseDBIntent);
            }
        });
    }
}
