package com.example.admin.services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.admin.services.Services.MyBoundService;
import com.example.admin.services.Services.MyIntentService;
import com.example.admin.services.Services.MyJobService;
import com.example.admin.services.Services.MyNormalService;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity_LOGTAG";
    private MyBoundService myBoundService;
    private boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evtService(View view) {
        Intent boundIntent = new Intent(this, MyBoundService.class);
        Intent intIntent = new Intent(this, MyIntentService.class);
        Intent normalIntent = new Intent(this, MyNormalService.class);

        switch(view.getId()){
            case R.id.btnScheduleService:
                ComponentName componentName = new ComponentName(this, MyJobService.class);
                JobInfo.Builder jobInfo = new JobInfo.Builder(0, componentName);
                jobInfo.setMinimumLatency(1000); //After one second, run
                jobInfo.setOverrideDeadline(1500); //Since this kind of thread runs based on conditions and not in time it could be executed at an undefined time, this lines tells it may not take longer than 1500 ms
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                    jobScheduler.schedule(jobInfo.build());
                }
                break;

            case R.id.btnBindService:
                Toast.makeText(MainActivity.this, "Binding", Toast.LENGTH_SHORT).show();
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnStartIntentService:
                intIntent.putExtra("KEY", "This is an intent service repo");
                intIntent.setAction("getRepo");
                startService(intIntent);
                break;

            case R.id.btnUnbindService:
                Toast.makeText(MainActivity.this, "Unbinding", Toast.LENGTH_SHORT).show();

                if(isBound){
                    unbindService(serviceConnection);
                    isBound = false;
                }
                break;

            case R.id.btnStartNormalService:
                normalIntent.putExtra("KEY", "This is a normal service");
                startService(normalIntent);
                break;

            case R.id.btnStopNormalServuce:
                normalIntent.putExtra("KEY", "Stopping normal service");
                stopService(normalIntent);
                break;

        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();
            Log.d(TAG, "onServiceConnected: " + myBoundService.GetRandomData());
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected: ");
            isBound = false;
        }
    };
}
