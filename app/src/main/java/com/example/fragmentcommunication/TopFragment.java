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
    Button mNextButton;
    EditText mEditText;

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

        mEditText = view.findViewById(R.id.editTextNumber);
        mNextButton = view.findViewById(R.id.next_button);
        mNextButton.setOnClickListener((button) -> {
            Bundle result = new Bundle();
            result.putString("timer_duration", mEditText.getText().toString());
            getParentFragmentManager().setFragmentResult("timer_duration_request_key", result);
        });
    }
}