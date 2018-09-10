package com.example.caballep.bbvacompass;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.caballep.bbvacompass.helper.PermissionHelper;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Calling single permission");
        PermissionHelper.askPermission(this, Manifest.permission.CAMERA);

        Log.d(TAG, "onCreate: Calling multiple permissions 1");
        PermissionHelper.askPermissions(this, Manifest.permission.INTERNET, Manifest.permission.CAMERA);

        String[] permissions = new String[2];
        permissions[0] = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        permissions[1] = Manifest.permission.ACCESS_FINE_LOCATION;

        Log.d(TAG, "onCreate: Calling multiple permissions 2");
        PermissionHelper.askPermissions(this, permissions);
    }
}
