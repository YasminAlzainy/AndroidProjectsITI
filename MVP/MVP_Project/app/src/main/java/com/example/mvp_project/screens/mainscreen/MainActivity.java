package com.example.mvp_project.screens.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp_project.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    Button enterButton;
    EditText usernameET;
    MainContract.MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterButton = findViewById(R.id.enterbtn);
        usernameET = findViewById(R.id.username);
        presenter = new MainPresenterImpl(this);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(usernameET.getText().toString());
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
