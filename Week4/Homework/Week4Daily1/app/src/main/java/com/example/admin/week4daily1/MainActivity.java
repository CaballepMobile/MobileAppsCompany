package com.example.admin.week4daily1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.week4daily1.model.User;
import com.example.admin.week4daily1.presenter.Presenter;
import com.example.admin.week4daily1.view.UserView;

public class MainActivity extends AppCompatActivity implements UserView {

    public static final String TAG = "MainActivity_LOG";
    
    private Presenter presenter;
    private TextView tvUserName, tvName, tvLocation, tvBio, tvFollowers;
    private EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);
        BindViews();
    }

    private void BindViews(){

        tvUserName = findViewById(R.id.tvUserName_MainActivity);
        tvName = findViewById(R.id.tvName_MainActivity);
        tvLocation = findViewById(R.id.tvLocation_MainActivity);
        tvBio = findViewById(R.id.tvBio_MainActivity);
        tvFollowers = findViewById(R.id.tvFollowers_MainActivity);
        etUserName = findViewById(R.id.etUserName_MainActivity);
    }

    public void evtSearch(View view) {

        Log.d(TAG, "evtSearch: ");
        presenter.getUser(etUserName.getText().toString());
    }

    @Override
    public void userReady(User user) {

        Log.d(TAG, "userReady: ");
        tvName.setText(user.getName());
    }
}
