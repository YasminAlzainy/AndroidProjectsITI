package yasmin.ayman.alzainy.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
