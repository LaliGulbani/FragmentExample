package laligulbani.by.fragmentexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import laligulbani.by.fragmentexample.R;


public class FragmentTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view_one = inflater.inflate(R.layout.fragment2, container, false);
        Button old = (Button)view_one.findViewById(R.id.old_activity);
        old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view_one;
    }
}
