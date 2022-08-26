package com.example.fragmentcommunication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class BottomFragment extends Fragment {
    private static final String TAG = "BottomFragment";
    public static final String TIMER_DURATION_ARG = "timer_duration_arg";
    private TextView mTimerTV;
    private Button startTimerButton;

    public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTimerTV = view.findViewById(R.id.time_tv);
        startTimerButton = view.findViewById(R.id.start_timer_button);
        startTimerButton.setOnClickListener(button -> {
            startTimer();
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            String timerDuration = args.getString(TIMER_DURATION_ARG);
            Log.d(TAG, "onStart: " + timerDuration);
            mTimerTV.setText(timerDuration);
        }
    }

    private void startTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int currentTime = Integer.parseInt(mTimerTV.getText().toString()) - 1;
                if (currentTime == 0) {
                    timer.cancel();
                }
                if (getActivity() != null) {
                    getActivity().runOnUiThread(() -> mTimerTV.setText(String.valueOf(currentTime)));
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}