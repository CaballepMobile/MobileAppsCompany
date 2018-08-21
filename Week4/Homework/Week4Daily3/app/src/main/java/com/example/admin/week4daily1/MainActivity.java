package com.example.admin.week4daily1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.week4daily1.model.User;
import com.example.admin.week4daily1.presenter.Presenter;
import com.example.admin.week4daily1.service.UserAPI;
import com.example.admin.week4daily1.view.UserView;

public class MainActivity extends AppCompatActivity implements UserView {

    private Presenter presenter;
    private TextView tvUserName, tvName, tvLocation, tvBio, tvFollowers;

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
    }

    public void evtSearch(View view) {
        presenter.getUser();
    }

    @Override
    public void userReady(User user) {
        tvName.setText(user.getName());
    }
}
