package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentCommunication {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.top_fragment_container, TopFragment.class, null)
                .add(R.id.bottom_fragment_container, BottomFragment.class, null)
                .commit();
        }
    }

    @Override
    public void passTimerDurationToBottomFragment(String duration) {
        Log.d(TAG, "passTimerDurationToBottomFragment: " + duration);
        BottomFragment bottomFragment = new BottomFragment();
        Bundle args = new Bundle();
        args.putString(BottomFragment.TIMER_DURATION_ARG, duration);
        bottomFragment.setArguments(args);
        getSupportFragmentManager()
            .beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.bottom_fragment_container, bottomFragment)
            .commit();
    }
}