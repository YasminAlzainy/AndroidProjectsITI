package yasmin.ayman.alzainy.boundservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BoundService boundService;
    private boolean isBound;
    private ServiceConnection serviceConnection;
    private Button btnShowTime;
    private TextView tvShowTime;

    public MainActivity() {
        isBound = false;
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName className, IBinder service) {
                BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
                boundService = myBinder.getService();
                isBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound = false;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowTime = findViewById(R.id.btnShowTime);
        tvShowTime = findViewById(R.id.tvShowTime);

        Intent boundIntent = new Intent(MainActivity.this, BoundService.class);
        bindService(boundIntent, serviceConnection, BIND_AUTO_CREATE);


        btnShowTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentTime = boundService.getCurrentTime();
                tvShowTime.setText(currentTime);
            }
        });
    }


}
