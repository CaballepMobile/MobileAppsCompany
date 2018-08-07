package com.example.admin.daily1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbFirst, pbSecond, pbThird, pb4th;
    private Button btnRunThreads;
    private boolean firstRun = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbFirst = findViewById(R.id.pbFirst);
        pbSecond = findViewById(R.id.pbSecond);
        pbThird = findViewById(R.id.pbThird);
        pb4th = findViewById(R.id.pb4th);
        btnRunThreads = findViewById(R.id.btnRunThreads);

        btnRunThreads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstRun) {
                    StartParallelThreads();
                    firstRun = false;
                } else {
                    if (ProgressCompleted()) {
                        StartParallelThreads();
                    } else {
                        Toast.makeText(MainActivity.this, "You must wait for all the threads to finish.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean ProgressCompleted() {
        if (pbFirst.getMax() == pbFirst.getProgress() && pbSecond.getMax() == pbSecond.getProgress() && pbThird.getMax() == pbThird.getProgress() && pb4th.getMax() == pb4th.getProgress()) {
            return true;
        }
        return false;
    }

    private void StartParallelThreads() {

        byte progressBarMaxValue = 100;

        final byte firstMax = (byte) (new Random().nextInt(progressBarMaxValue) + 1);
        final byte secondMax = (byte) (new Random().nextInt(progressBarMaxValue) + 1);
        final byte thirdMax = (byte) (new Random().nextInt(progressBarMaxValue) + 1);
        final byte fourthMax = (byte) (new Random().nextInt(progressBarMaxValue) + 1);

        pbFirst.setMax(firstMax);
        pbSecond.setMax(secondMax);
        pbThird.setMax(thirdMax);
        pb4th.setMax(fourthMax);

        final short awaitTime = 100;

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <= firstMax; i++) {
                    pbFirst.setProgress(i);
                    try {
                        Thread.sleep(awaitTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= secondMax; i++) {
                    pbSecond.setProgress(i);
                    try {
                        Thread.sleep(awaitTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <= thirdMax; i++) {
                    pbThird.setProgress(i);
                    try {
                        Thread.sleep(awaitTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= fourthMax; i++) {
                    pb4th.setProgress(i);
                    try {
                        Thread.sleep(awaitTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /*  I WANTED TO DO SOMETHING FANCY HERE BUT I DID NOT WORK OUT WELL

    private void StartParallelThreads() {
        for (i = 0; i < 4; i++) {
            randomValue = (byte) (new Random().nextInt(progressBarMaxValue) + 1);
            UpdateMaxValue(i, randomValue);

            new Thread() {
                @Override
                public void run() {
                    byte id = i;
                    for (byte e = 1; e < randomValue; e++) {
                        try {
                            Thread.sleep(awaitTime);
                            UpdateProgress(id, e);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void UpdateMaxValue(byte pbId, byte maxValue) {
        switch (pbId) {
            case 1:
                pbFirst.setMax(maxValue);
                break;
            case 2:
                pbSecond.setMax(maxValue);
                break;
            case 3:
                pbThird.setMax(maxValue);
                break;
            case 4:
                pb4th.setMax(maxValue);
                break;
        }
    }

    private void UpdateProgress(byte pbId, byte value) {
        switch (pbId) {
            case 1:
                pbFirst.setProgress(value);
                break;
            case 2:
                pbSecond.setProgress(value);
                break;
            case 3:
                pbThird.setProgress(value);
                break;
            case 4:
                pb4th.setProgress(value);
                break;
        }
    }
    */
}