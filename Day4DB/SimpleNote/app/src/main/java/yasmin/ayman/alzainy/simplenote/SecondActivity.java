package yasmin.ayman.alzainy.simplenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button cancleBtn ;
    TextView titleText , bodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        cancleBtn = findViewById(R.id.cancleBtnSecond);
        titleText = findViewById(R.id.titleShow);
        bodyText = findViewById(R.id.bodyShow);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        titleText.setText(intent.getStringExtra(MainActivity.BODY));
        bodyText.setText(intent.getStringExtra(MainActivity.TITLE));

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
