package com.lk.fundstest.home;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lk.fundstest.R;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            initScreen();

        } else {
            mainFragment = (MainFragment) getSupportFragmentManager().getFragments().get(0);
        }
    }

    private void initScreen() {
        mainFragment = new MainFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commit();
    }


    @Override
    public void onBackPressed() {

        if (!mainFragment.onBackPressed()) {
            super.onBackPressed();

        } else {
        }
    }
}
