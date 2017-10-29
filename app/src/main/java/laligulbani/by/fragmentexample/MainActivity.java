package laligulbani.by.fragmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import laligulbani.by.fragmentexample.fragment.FragmentOne;
import laligulbani.by.fragmentexample.fragment.FragmentTwo;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";

    private Fragment mCurrentFragment;
    private FragmentOne mfragmentOne;
    private FragmentTwo mfragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate" );
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

    public void newActivity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void oldActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "omPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
