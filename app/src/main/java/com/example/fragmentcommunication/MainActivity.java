package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentCommunication {
    private static final String TAG = "MainActivity";

    private TopFragment topFragment;
    private BottomFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            topFragment = new TopFragment();
            bottomFragment = new BottomFragment();
            getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.top_fragment_container, topFragment)
                .add(R.id.bottom_fragment_container, bottomFragment)
                .commit();
        }
    }

    @Override
    public void passTimerDurationToBottomFragment(String duration) {
        Log.d(TAG, "passTimerDurationToBottomFragment: " + duration);
        bottomFragment.changeTimerText(duration);
    }
}