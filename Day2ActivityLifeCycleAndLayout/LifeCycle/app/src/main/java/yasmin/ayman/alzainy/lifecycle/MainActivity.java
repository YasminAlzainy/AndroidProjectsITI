package yasmin.ayman.alzainy.lifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String COUNTER = "Counter" ;
    private int counter = 0 ;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Life" , "onCreate1");
        counterTextView = findViewById(R.id.counter);

        if(savedInstanceState != null)
        {
            counter = savedInstanceState.getInt(COUNTER);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Life" , "onStart1");
        counter++;

        counterTextView.setText(Integer.toString(counter));


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Life" , "onResume1");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Life" , "onPause1");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Life" , "onSaveInstanceState1");
        outState.putInt(COUNTER , counter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Life" , "onStop1");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Life" , "onDestroy1");

    }
}
