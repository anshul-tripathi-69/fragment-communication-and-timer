package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NextButtonClickListener {
    private BottomFragment bottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            bottomFragment = new BottomFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.top_fragment_container, TopFragment.class, null)
                    .add(R.id.bottom_fragment_container, bottomFragment)
                    .commit();
        }
    }

    @Override
    public void setTimerText() {
        bottomFragment.updateTimerText();
    }
}