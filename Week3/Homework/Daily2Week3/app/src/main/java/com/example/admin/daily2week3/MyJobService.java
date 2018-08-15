package com.example.admin.daily2week3;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import android.util.Log;

public class MyJobService extends JobService {
    public static final String TAG = "MyJobService_LOGTAG";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "onStartJob: ");
        PersistableBundle persistableBundle = jobParameters.getExtras();

        Person person = new Person();

        person.setName(persistableBundle.getString("person_name_data"));
        person.setLastName(persistableBundle.getString("person_last_name_data"));
        person.setAge(persistableBundle.getString("person_age_data"));
        person.setGenre(persistableBundle.getString("person_genre_data"));

        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        intent.putExtra("data", person);
        getApplicationContext().startService(intent);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}