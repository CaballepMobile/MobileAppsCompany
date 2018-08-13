package com.example.admin.weekendweek2.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.weekendweek2.R;

import java.util.Timer;
import java.util.TimerTask;

public class CounterFragment extends Fragment {

    private static class TimerState {
        public static byte STOPED = 0;
        public static byte RUNNING = 1;
        public static byte PAUSED = 2;
    }

    private VisualizerFragment visualizerFragment;
    private byte timerStateVal = TimerState.STOPED;
    private short seconds = 0;
    Timer counterTimer = new Timer();

    Button btnStart, btnStop, btnPause;

    OnCounterFragmentListener callBack;

    public interface OnCounterFragmentListener {
        public void StartCounter(short seconds);
        public void StopCounter(short seconds);
        public void PauseCounter();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnCounterFragmentListener)
        {
            callBack = (OnCounterFragmentListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener.");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_panel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //VisualizerFragment transaction = getChildFragmentManager().beginTransaction();
        //transaction.replace(R.id.child_fragment_container, childFragment).commit();
        InitializeViews(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callBack = null;
    }

    private void InitializeViews(View view){
        btnStart = view.findViewById(R.id.btnStart_fragment_panel);
        btnStop = view.findViewById(R.id.btnStop_fragment_panel);
        btnPause = view.findViewById(R.id.btnPause_fragment_panel);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerStateVal == TimerState.STOPED || timerStateVal == TimerState.PAUSED){
                    StartCounter();
                    timerStateVal = TimerState.RUNNING;
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerStateVal == TimerState.RUNNING){
                    PauseCounter();
                    timerStateVal = TimerState.PAUSED;
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StopCounter();
                timerStateVal = TimerState.STOPED;
            }
        });

        visualizerFragment = new VisualizerFragment();
        getChildFragmentManager().beginTransaction()
                .add(R.id.fgtVisualizer, visualizerFragment, "VisualizerFragment")
                .addToBackStack("VisualizerFragment")
                .commit();
    }

    private void StartCounter(){
        counterTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                visualizerFragment.SetCounterText(seconds);
            }
        }, 1000, 1000);
    }

    private void StopCounter(){
        seconds = 0;
        counterTimer.cancel();
        callBack.StopCounter(seconds);
    }

    private void PauseCounter(){
        counterTimer.cancel();
        callBack.PauseCounter();
    }
}
