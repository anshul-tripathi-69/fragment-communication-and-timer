package com.example.fragmentcommunication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopFragment extends Fragment {
    private Button nextButton;
    private NextButtonClickListener nextButtonClickListener;
    private DataBridge dataBridge;
    private EditText timerET;

    public TopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBridge = DataBridge.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        nextButtonClickListener = (MainActivity) getActivity();
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nextButton = (Button) view.findViewById(R.id.next_button);
        timerET = (EditText) view.findViewById(R.id.editTextNumber);
        nextButton.setOnClickListener(button -> {
            dataBridge.setTimerDurationText(timerET.getText().toString());
            nextButtonClickListener.setTimerText();
        });
    }
}