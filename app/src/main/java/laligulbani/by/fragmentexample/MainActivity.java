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
    private Fragment mfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfragmentOne = new FragmentOne();
        mfragmentTwo = new FragmentTwo();



        (findViewById(R.id.show_fragment1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                mfragment = fm.findFragmentById(R.id.fragment_container);
                if(mfragment == null){
                    fm.beginTransaction()
                            .add(R.id.fragment_container, mfragmentOne)
                            .commit();
                }else{
                    fm.beginTransaction()
                    .hide(mfragmentTwo)
                            .commit();
                }



                /*FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.fragment_container);
                if(fragment == null){
                    fragment = new FragmentOne();
                    fragment = new FragmentTwo();
                    fm.beginTransaction()
                            .add(R.id.fragment_container, fragment)
                            .add(R.id.fragment_container, )
                            .commit();
                            (findViewById(R.id.show_hide)).setText(Hide);
                   }else{
                            fm.beginTransaction()
                                  .hide(fragmentOne)
                                  .hide(fragmentTwo)
                                  .commit();
                                  (findViewById(R.id.show_hide)).setText(Show);
/*
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentOne fragmentOne = new FragmentOne();
                FragmentTwo fragmentTwo = new FragmentTwo();

                fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragmentOne)
                .add(R.id.fragment_container,fragmentTwo)
                .commit();

            }
*/
            }
        });

        (findViewById(R.id.show_fragment2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                mfragment = fm.findFragmentById(R.id.fragment_container);
                if(mfragment == null){
                    fm.beginTransaction()
                            .add(R.id.fragment_container, mfragmentTwo)
                            .commit();
                }else{
                    fm.beginTransaction()
                            .hide(mfragmentOne)
                            .commit();
                }


            }


        });

    }


    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .addToBackStack(null)

                .commit();


    }
}
