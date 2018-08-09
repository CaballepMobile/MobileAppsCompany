package com.example.admin.persistencedata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static String TAG = "[!]LOG[!] Lyfecycle_Second";
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.tvFirstValue);
        textView2 = findViewById(R.id.tvSecondaryValue);

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MY_PREF_FILE, Context.MODE_PRIVATE);
        textView1.setText(sharedPreferences.getString("value1", "default"));
        textView2.setText(sharedPreferences.getString("value2", "default"));

        Log.d(TAG, "onCreate: ");
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

}
