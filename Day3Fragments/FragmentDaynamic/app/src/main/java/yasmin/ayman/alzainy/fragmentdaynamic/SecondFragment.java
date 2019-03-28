package yasmin.ayman.alzainy.fragmentdaynamic;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private TextView countTextView;
    private int counter ;
    private static final String COUNTER = "Counter";

    public SecondFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        countTextView = view.findViewById(R.id.textView);
        Log.i("Fragments","New Fragment 2");
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER);
        } else {
            counter = 0;
        }
        return view;
    }

    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, counter);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void changeText(int count) {

        countTextView.setText(Integer.toString(count));
    }

}
