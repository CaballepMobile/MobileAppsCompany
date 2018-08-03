package com.example.admin.layoutandviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private String TAG = "Second";
    private TextView tvValue;
    private TextView tvPersonName;
    private TextView tvPersonGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvValue = findViewById(R.id.tvValue);
        tvPersonName = findViewById(R.id.tvPersonName);
        tvPersonGenre = findViewById(R.id.tvPersonGenre);
        Intent intent = getIntent();

        switch(intent.getAction()){
            case "sendingValue":
                Log.d(TAG, "onCreate: " + intent.getStringExtra(getString(R.string.KEY_VALUE1)));


                tvValue.setText(intent.getStringExtra(getString(R.string.KEY_VALUE1)));
                break;

            case "sendingPerson":
                Person person = (Person) intent.getSerializableExtra("person");
                Log.d(TAG, "onCreate: " + person.getName() + " - " + person.gender);


                tvPersonName.setText(person.getName());
                tvPersonGenre.setText(person.getGender());
                break;
        }
    }
}