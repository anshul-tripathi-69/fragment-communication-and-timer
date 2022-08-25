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
    private FragmentCommunication onClickNextButton;
    private EditText timerEditText;
    private Button nextButton;

    public TopFragment() {
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
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onClickNextButton = (MainActivity) getActivity();
        nextButton = (Button) getView().findViewById(R.id.next_button);
        timerEditText = (EditText) getView().findViewById(R.id.editTextNumber);
        nextButton.setOnClickListener(nextButton -> {
            onClickNextButton.passTimerDurationToBottomFragment(timerEditText.getText().toString());
        });
    }
}