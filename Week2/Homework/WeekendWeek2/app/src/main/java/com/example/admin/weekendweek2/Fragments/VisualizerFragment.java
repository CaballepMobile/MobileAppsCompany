package com.example.admin.weekendweek2.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.weekendweek2.R;

public class VisualizerFragment extends Fragment {

    TextView tvCounter_fragment_visualizer;
    public void SetCounterText(short value){
        tvCounter_fragment_visualizer.setText(String.valueOf(value));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visualizer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCounter_fragment_visualizer = view.findViewById(R.id.tvCounter_fragment_visualizer);
    }
}