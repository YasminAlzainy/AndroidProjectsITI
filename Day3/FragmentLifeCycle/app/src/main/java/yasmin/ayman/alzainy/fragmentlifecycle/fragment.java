package yasmin.ayman.alzainy.fragmentlifecycle;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment extends Fragment {


    public fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("FragmentLF" , "onAttachFragment");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FragmentLF" , "onCreateFragment");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("FragmentLF" , "onCreateViewFragment");
        return inflater.inflate(R.layout.fragment_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getActivity();

        super.onActivityCreated(savedInstanceState);
        Log.i("FragmentLF" , "onActivityCreatedFragment");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FragmentLF" , "onStartFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FragmentLF" , "onResumeFragment");

    }

    ////////////////////////

    @Override
    public void onPause() {
        super.onPause();
        Log.i("FragmentLF" , "onPauseFragment");


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("FragmentLF" , "onSaveInstanceStateFragment");


    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("FragmentLF" , "onStopFragment");


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("FragmentLF" , "onDestroyViewFragment");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("FragmentLF" , "onDestroyFragment");

    }

    @Override
    public void onDetach() {
        Log.i("FragmentLF" , "onDetachFragment");
        super.onDetach();
    }
}
