package com.example.fragmentcommunication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BottomFragment extends Fragment {
    private static final String TAG = "BottomFragment";
    public static final String TIMER_DURATION_ARG = "timer_duration_arg";
    private TextView timerTV;
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

        timerTV = (TextView) view.findViewById(R.id.time_tv);
        startTimerButton = (Button) view.findViewById(R.id.start_timer_button);
        startTimerButton.setOnClickListener(button -> {
            long totalTime = Long.parseLong(timerTV.getText().toString()) * 1000 + 1000;
            new CountDownTimer(totalTime, 1000) {
                @Override
                public void onFinish() {
                    timerTV.setText("0");
                }

                @Override
                public void onTick(long l) {
                    int timeInSeconds = (int) l / 1000;
                    timerTV.setText(String.valueOf(timeInSeconds));
                }
            }.start();
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            String timerDuration = args.getString(TIMER_DURATION_ARG);
            Log.d(TAG, "onStart: " + timerDuration);
            timerTV.setText(timerDuration);
        }
    }
}