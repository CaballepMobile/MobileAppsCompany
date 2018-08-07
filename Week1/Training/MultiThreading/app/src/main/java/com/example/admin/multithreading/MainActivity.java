package com.example.admin.multithreading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTesting = findViewById(R.id.tvTesting);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        //EventBus.getDefault().unregister(this);
        super.onStop();
    }
    /*
    @Suscribe(threadMode = ThreadMode.Main)
    public void onMessageEvent(MessageEvent messageEvent){
        Toast.makeText(this, messageEvent.getMessage(), Toast.LENGTH_SHORT).show();
    }
    */
    public void executeThread(View view) {
        int viewId = view.getId();

        switch (viewId) {
            case R.id.btnThread:
                TestThread testThread = new TestThread(tvTesting);
                testThread.start();
                break;

            case R.id.btnRunnable:

                break;
            case R.id.btnAsyncTask:

                break;
            case R.id.btnThreadHandlerMessage:

                break;
        }
    }
}