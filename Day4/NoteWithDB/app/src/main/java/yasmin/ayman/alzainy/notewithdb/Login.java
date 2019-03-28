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

public class Login extends AppCompatActivity {

    public static final String USER_INFO = "USER_INFO";
    public static final String USER_NAME = "user_name";
    public static final String USER_Password = "user_pass";

    private EditText nameEditText , passwordEditText;
    private Button registrationBTN,loginBTN;

    private  SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registrationBTN = findViewById(R.id.registrationBTN);
        loginBTN = findViewById(R.id.loginBTN);

        sharedPreferences =getSharedPreferences(USER_INFO, MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    protected void onStart() {
        super.onStart();

        registrationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(USER_NAME , nameEditText.getText().toString());
                editor.putString(USER_Password , passwordEditText.getText().toString());
                editor.commit();

                Intent mainIntent = new Intent(Login.this , MainActivity.class);
                startActivity(mainIntent);

            }
        });

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = sharedPreferences.getString(USER_NAME , null);
                String userPass = sharedPreferences.getString(USER_Password , null);

                if(userName.equals(nameEditText.getText().toString()) && userPass.equals(passwordEditText.getText().toString()))
                {
                    Intent mainIntent = new Intent(Login.this , MainActivity.class);
                    startActivity(mainIntent);
                }

            }
        });
    }
}
