package yasmin.ayman.alzainy.fragmentdaynamic;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private static final String COUNTER = "Counter";
    private Communnicator communnicator;
    private Button button;
    private int counter;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.countBtn);
        Log.i("Fragments","New Fragment 1");

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER);
        } else {
            counter = 0;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                communnicator.count(counter);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, counter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communnicator = (Communnicator) getActivity();
    }
}
