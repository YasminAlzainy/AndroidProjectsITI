package yasmin.ayman.alzainy.myfirebase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NoteActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String BODY = "Body";
    public static final String USER_INFO = "USER_INFO";
    public static final String USER_NAME = "user_name";

    Button cancleBtn, submitBtn;
    EditText titleText, bodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        cancleBtn = findViewById(R.id.btnCancel);
        submitBtn = findViewById(R.id.btnSubmit);
        titleText = findViewById(R.id.titleText);
        bodyText = findViewById(R.id.bodyText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(USER_INFO, MODE_PRIVATE);

        String userName = sharedPreferences.getString(USER_NAME, null);

        Toast.makeText(this, "Hello " + userName, Toast.LENGTH_SHORT).show();

//        cancleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
 //       });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteActivity.this, ConfirmNoteActivity.class);
                intent.putExtra(TITLE, titleText.getText().toString());
                intent.putExtra(BODY, bodyText.getText().toString());
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Life", "onDestroy: ");
    }
}
