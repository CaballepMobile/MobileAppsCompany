package com.example.admin.daily2week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.List;

public class PeopleActivity extends AppCompatActivity {

    private static final String TAG = "PeopleActivity_LOGTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        Log.d(TAG, "onCreate: ");
        FillRecyclerView();
    }

    private void FillRecyclerView(){

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Person> people = databaseHelper.GetPeople();

        RecyclerView recyclerView = findViewById(R.id.rvPeople);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        PeopleRecyclerAdapter peopleRecyclerAdapter = new PeopleRecyclerAdapter(people);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(peopleRecyclerAdapter);
        recyclerView.setItemAnimator(itemAnimator);
    }
}