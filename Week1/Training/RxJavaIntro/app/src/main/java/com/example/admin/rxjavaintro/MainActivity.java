package com.example.admin.rxjavaintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "[LOGD]MainActivity";
    private TextView tvNumbers;
    private Button btnStartObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumbers = findViewById(R.id.tvNumbers);
        btnStartObservable = findViewById(R.id.btnStartObservable);
    }
}