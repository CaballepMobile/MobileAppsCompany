package com.example.admin.weekendweek2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.admin.weekendweek2.Fragments.CounterFragment;
import com.example.admin.weekendweek2.Fragments.VisualizerFragment;

public class TwoFragmentCounterActivity extends AppCompatActivity implements CounterFragment.OnCounterFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_fragment_counter);

        CounterFragment counterFragment = new CounterFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fgtPanel, counterFragment, "CounterFragment")
                .addToBackStack("CounterFragment")
                .commit();
    }

    @Override
    public void StartCounter(short seconds) {
        Toast.makeText(this, "Starting Counter at " + seconds, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void StopCounter(short seconds) {
        Toast.makeText(this, "Seconds settled to 0", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void PauseCounter() {
        Toast.makeText(this, "Counter paused", Toast.LENGTH_SHORT).show();
    }
}
