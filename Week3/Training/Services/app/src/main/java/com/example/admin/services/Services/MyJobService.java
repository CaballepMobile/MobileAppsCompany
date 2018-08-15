package com.example.admin.services.Services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi()
public class MyJobService extends JobService {

    private static final String TAG = "MyJobService_LOGTAG";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "onStartJob: ");

        //One service can call another
        Intent intent = new Intent(getApplicationContext(), MyScheduleService.class);
        getApplicationContext().startService(intent);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
