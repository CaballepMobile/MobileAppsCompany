package com.example.caballep.intentservicebutton;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caballep.intentservicebutton.services.CounterService;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOG";
    public TextView tv;
    private Button btn;
    private final Handler messageHandler = new MessageHandler(this);
    private boolean isStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        tv.setVisibility(View.GONE);
    }

    public void evtClick(View view) {

        Log.d(TAG, "evtClick: ");
        Intent intentService = new Intent(this, CounterService.class);
        intentService.putExtra("Messenger", new Messenger(messageHandler));

        this.startService(intentService);
        ((ViewGroup)btn.getParent()).removeView(btn);
        tv.setVisibility(View.VISIBLE);
    }


}
