package com.example.admin.weekendweek2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    private Button btnSkip;
    private ProgressBar pgrWelcome;
    private MediaPlayer mediaPlayer;
    private int duration;
    private final byte buttonSkipTimeInSecondsToUnclock = 5;
    private byte currentTimeInSeconds = 0;
    boolean buttonReleased = false;

    private Handler handler;

    private final byte UNLOCK_BUTTON = 1;
    private final byte SET_TEXT_BUTTON = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetScreen();
        setContentView(R.layout.activity_welcome);


        InitializeMusic();
        InitializeViews();
        StartThread();
        //backgroundToast(this, "What");
    }

    private void SetScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void InitializeViews(){
        pgrWelcome = findViewById(R.id.pgrWelcome);
        btnSkip = findViewById(R.id.btnSkip);
        pgrWelcome.setMax(duration);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMainActivity();
            }
        });
    }

    private void InitializeMusic(){
        mediaPlayer = MediaPlayer.create(this, R.raw.gravity_falls);
        mediaPlayer.start();
        duration = mediaPlayer.getDuration();
    }

    private void UpdateProgress(){
        //Toast.makeText(this, mediaPlayer.getCurrentPosition()/duration*pgrWelcome.getMax(), Toast.LENGTH_SHORT).show();
        pgrWelcome.setProgress(currentTimeInSeconds*10);
    }

    private void UnlockButton(){
        btnSkip.setEnabled(true);
        btnSkip.setBackgroundColor(Color.BLUE);
    }

    private void SetTextButton(){
        String buttonText = "Skip (" + (buttonSkipTimeInSecondsToUnclock - currentTimeInSeconds) + ")";
        btnSkip.setText(buttonText);
    }

    private void GoToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mediaPlayer.stop();
        startActivity(intent);
    }

    private void StartThread(){

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        UpdateProgress();
                        if(currentTimeInSeconds >= buttonSkipTimeInSecondsToUnclock){
                            handler.sendEmptyMessage(UNLOCK_BUTTON);
                            buttonReleased = true;
                        }
                        currentTimeInSeconds += 1;
                        if(!buttonReleased){
                            handler.sendEmptyMessage(SET_TEXT_BUTTON);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}