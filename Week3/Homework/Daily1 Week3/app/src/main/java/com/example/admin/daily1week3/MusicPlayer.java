package com.example.admin.daily1week3;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicPlayer {

    private static MusicPlayer musicPlayer_staticInstance;
    private Context context;
    private MediaPlayer mediaPlayer;

    public MusicPlayer(Context context) {

        this.context = context;
        mediaPlayer = MediaPlayer.create(this.context, R.raw.gravity_falls_song);
        mediaPlayer.start();
    }

    public static MusicPlayer getInstance(Context context) {
        if (musicPlayer_staticInstance == null) {
            musicPlayer_staticInstance = new MusicPlayer(context);
        }

        return musicPlayer_staticInstance;
    }

    public void PlayMusic() {
        mediaPlayer = MediaPlayer.create(this.context, R.raw.gravity_falls_song);
        mediaPlayer.start();

        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }

    public void StopMusic() {
        if(mediaPlayer.isPlaying()){
           mediaPlayer.pause();
        }
    }
}