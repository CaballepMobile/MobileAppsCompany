package com.example.caballep.isschallenge.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.caballep.isschallenge.R;
import com.example.caballep.isschallenge.helper.LocationHelper;
import com.example.caballep.isschallenge.helper.PermissionManager;
import com.example.caballep.isschallenge.remote.ISSService;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOG";
    PermissionManager permissionManager;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionManager = new PermissionManager(this);
        permissionManager.checkPermission();

        LocationHelper locationHelper = new LocationHelper(this);

        ISSService issService = new ISSService();

        issService.getISSData(locationHelper.getLatitude(), locationHelper.getLongitude())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    Log.d(TAG, "onCreate: " + response.getMessage());
                }, Throwable::printStackTrace);
    }
}
