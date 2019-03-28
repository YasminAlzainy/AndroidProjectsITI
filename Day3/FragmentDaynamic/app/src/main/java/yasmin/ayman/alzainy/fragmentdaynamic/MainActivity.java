package yasmin.ayman.alzainy.fragmentdaynamic;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Communnicator {

    private static final String SECOND_FRAGMENT = "Second_Fragment";
    private SecondFragment secondFragment , firstFragment;
    public static final String COUNTER = "Counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState == null)
        {

            FirstFragment firstFragment = new FirstFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.first, firstFragment, "first");
            secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.second, secondFragment, "second");

            fragmentTransaction.commit();
        }
        else
        {
         //  secondFragment = getParent().gw
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void count(int counter) {
        Log.i("counter", Integer.toString(counter));
        secondFragment.changeText(counter);
    }

}
