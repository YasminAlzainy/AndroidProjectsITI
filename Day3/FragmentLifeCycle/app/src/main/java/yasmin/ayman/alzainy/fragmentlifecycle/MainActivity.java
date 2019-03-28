package yasmin.ayman.alzainy.fragmentlifecycle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FragmentLF" , "onCreatActivity");
        setContentView(R.layout.activity_main);
        Log.i("FragmentLF" , "ActivityCreated ^_^");

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.i("FragmentLF" , "onAttachFragmentActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("FragmentLF" , "onStarttActivity");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("FragmentLF" , "onResumeActivity");


    }

    ///////////////////////////


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("FragmentLF" , "onPauseActivity");


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("FragmentLF" , "onSaveInstanceStateActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("FragmentLF" , "onStopActivity");


    }

    @Override
    protected void onDestroy() {
        Log.i("FragmentLF" , "onDestroyActivity");
        super.onDestroy();

    }
}
