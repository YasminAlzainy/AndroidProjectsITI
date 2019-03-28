package yasmin.ayman.alzainy.notewithdb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static yasmin.ayman.alzainy.notewithdb.Login.USER_INFO;
import static yasmin.ayman.alzainy.notewithdb.Login.USER_NAME;

public class MainActivity extends AppCompatActivity {
        public static final String TITLE = "title" ;
        public static final String BODY = "Body";
        Button cancleBtn , submitBtn;
        EditText titleText , bodyText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            cancleBtn = findViewById(R.id.cancleBtn);
            submitBtn = findViewById(R.id.submitBtn);
            titleText = findViewById(R.id.titleText);
            bodyText = findViewById(R.id.bodyText);
        }

        @Override
        protected void onStart() {
            super.onStart();

            SharedPreferences sharedPreferences =getSharedPreferences(USER_INFO, MODE_PRIVATE);

            String userName = sharedPreferences.getString(USER_NAME , null);

            Toast.makeText(this,"Hello "+ userName, Toast.LENGTH_SHORT).show();

            cancleBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                    intent.putExtra(TITLE  , titleText.getText().toString());
                    intent.putExtra(BODY , bodyText.getText().toString());
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

