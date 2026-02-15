package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HappyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_happy, container, false);
        TextView messageTextView = view.findViewById(R.id.tvMessage);
        if (getArguments() != null) {
            String nameFromActivity = getArguments().getString("my_name");

            if (nameFromActivity != null && !nameFromActivity.isEmpty()) {
                messageTextView.setText(nameFromActivity + " אני מרגיש מצוין!");
            }
        }

        return view;
    }
}