package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class NeutralFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // שים לב שפה אנחנו טוענים את ה-XML של הנטרלי
        return inflater.inflate(R.layout.fragment_neutral, container, false);
    }
}