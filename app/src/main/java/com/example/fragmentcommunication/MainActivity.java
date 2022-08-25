package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
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

    public void setTimerTextInBottomFragment(String timerDuration) {
        bottomFragment.setTimerText(timerDuration);
    }
}