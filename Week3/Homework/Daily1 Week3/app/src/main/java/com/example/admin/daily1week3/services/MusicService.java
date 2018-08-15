package com.example.admin.daily1week3.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import com.example.admin.daily1week3.R;

import static com.example.admin.daily1week3.App.CHANNEL_ID;

public class MusicService extends Service {

    public MusicService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        LaunchNotification();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void LaunchNotification() {
        Intent playIntent = new Intent("Play_Music");
        Intent stopIntent = new Intent("Stop_Music");

        playIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        stopIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent PendingPlayIntent = PendingIntent.getBroadcast(
                this, 0, playIntent, 0);

        PendingIntent PendingStopIntent = PendingIntent.getBroadcast(
                this, 0, stopIntent, 0);

        RemoteViews ContentView = new RemoteViews(getPackageName(),
                R.layout.notification_layout_music);

        ContentView.setOnClickPendingIntent(R.id.btnPlay, PendingPlayIntent);
        ContentView.setOnClickPendingIntent(R.id.btnStop, PendingStopIntent);
        ContentView.setImageViewResource(R.id.ivSong, R.drawable.gravity_falls);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this, CHANNEL_ID);

        mBuilder.setSmallIcon(R.drawable.ic_lmusic_black_24dp)
                .setContent(ContentView);

        Notification notification = mBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;


        startForeground(1, notification);
    }

    private void CheckPermissions() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}