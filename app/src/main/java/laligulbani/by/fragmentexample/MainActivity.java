package laligulbani.by.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import laligulbani.by.fragmentexample.fragment.FragmentOne;
import laligulbani.by.fragmentexample.fragment.FragmentTwo;

public class MainActivity extends FragmentActivity {
    private Fragment mCurrentFragment;
    private FragmentOne mfragmentOne;
    private FragmentTwo mfragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfragmentOne = new FragmentOne();
        mfragmentTwo = new FragmentTwo();


        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_container, mfragmentTwo)
                .hide(mfragmentTwo)
                .add(R.id.fragment_container, mfragmentOne)
                .hide(mfragmentOne)
                .commit();
        mCurrentFragment = mfragmentOne;


        (findViewById(R.id.show_fragment1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(mfragmentOne);

            }
        });

        (findViewById(R.id.show_fragment2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showFragment(mfragmentTwo);
            }


        });


    }


    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .hide(mCurrentFragment)
                .show(fragment)
                .addToBackStack(null)
                .commit();
        mCurrentFragment = fragment;

    }
}
