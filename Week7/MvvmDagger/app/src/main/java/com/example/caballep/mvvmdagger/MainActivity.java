package com.example.caballep.mvvmdagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    //Implementing ButterKnife just for this Activity
    @BindView(R.id.btnRoom)
    Button btnRoom;
    @BindView(R.id.btnRetrofit)
    Button btnRetrofit;
    @BindView(R.id.btnFirebase)
    Button btnFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evtOpenActivity(View view) {
        int btnId = view.getId();
        Intent newActivityIntent = null;

        switch (btnId) {
            case R.id.btnRoom:
                newActivityIntent = new Intent(this, RoomActivity.class);
                break;

            case R.id.btnRetrofit:
                newActivityIntent = new Intent(this, RetrofitActivity.class);
                break;

            case R.id.btnFirebase:
                newActivityIntent = new Intent(this, FirebaseActivity.class);
                break;
        }

        startActivity(newActivityIntent);
    }
}
