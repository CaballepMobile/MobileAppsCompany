package com.example.admin.daily2week3;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        PersistableBundle persistableBundle = new PersistableBundle();
        Person person = intent.getParcelableExtra("data");

        persistableBundle.putString("person_name_data", person.getName());
        persistableBundle.putString("person_last_name_data", person.getLastName());
        persistableBundle.putString("person_age_data", person.getAge());
        persistableBundle.putString("person_genre_data", person.getGenre());

        ComponentName componentName = new ComponentName(context, MyJobService.class);
        JobInfo.Builder jobInfoBuilder = new JobInfo.Builder(0, componentName);
        jobInfoBuilder.setOverrideDeadline(3000);
        jobInfoBuilder.setExtras(persistableBundle);
        JobScheduler jobSchduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobSchduler.schedule(jobInfoBuilder.build());
    }
}