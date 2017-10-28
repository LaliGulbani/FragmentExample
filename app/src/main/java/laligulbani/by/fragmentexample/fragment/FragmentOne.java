package laligulbani.by.fragmentexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import laligulbani.by.fragmentexample.MainActivity;
import laligulbani.by.fragmentexample.R;


public class FragmentOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        Button show = (Button) view.findViewById(R.id.new_activity);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    MainActivity ma = (MainActivity) getActivity();
                    ma.newActivity();
                }
                //Intent intent = new Intent(MainActivity.class, Main2Activity.class);
                //startActivity(intent);
            }
        });
        return view;
    }

}
