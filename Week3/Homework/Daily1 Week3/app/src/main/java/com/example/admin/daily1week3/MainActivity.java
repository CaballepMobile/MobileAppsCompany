package com.example.admin.daily1week3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.admin.daily1week3.services.MusicService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evtButtonsClick(View view) {

        switch (view.getId()) {
            case R.id.btnPlay:
                Intent playMusicIntent = new Intent(this, MusicService.class);
                ContextCompat.startForegroundService(this, playMusicIntent);
                break;
            case R.id.btnStop:
                Intent stopMusicIntent = new Intent(this, MusicService.class);
                ContextCompat.startForegroundService(this, stopMusicIntent);
                break;
        }
    }

    public static class MyMediaReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action != null) {
                switch (action) {
                    case "Play_Music":
                        MusicPlayer.getInstance(context).PlayMusic();
                        break;

                    case "Stop_Music":
                        MusicPlayer.getInstance(context).StopMusic();
                        break;
                }
            }
        }
    }
}