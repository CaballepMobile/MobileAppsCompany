package com.example.admin.persistencedata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG = "[!]LOG[!] Lifecycle_Main";
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.etVal1);
        editText2 = findViewById(R.id.etVal2);

        Log.d(TAG, "onCreate: ");
    }

    public void SaveData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value1", editText1.getText().toString());
        editor.putString("value2", editText2.getText().toString());
        editor.commit(); //Remember young Jose, commit for MainThread, apply for DoInBackground and not Stuck the MainThread

        startActivity(new Intent(this, Main2Activity.class));
    }

    public void GetData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        Log.d(TAG, "GetData: " + sharedPreferences.getString("value", "default"));
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged: ");
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
        }
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
        }
        if(newConfig.orientation == Configuration.TOUCHSCREEN_FINGER){
            Toast.makeText(this, "Finger touch", Toast.LENGTH_SHORT).show();
        }
    }
}
