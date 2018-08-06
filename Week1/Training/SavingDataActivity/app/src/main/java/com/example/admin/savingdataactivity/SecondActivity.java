package com.example.admin.savingdataactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        List<Person> personList = getIntent().getParcelableArrayListExtra("persons");
        //Toast.makeText(this, personList.size() + "", Toast.LENGTH_SHORT).show();

        for (Person person : personList){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, person.getName(), Toast.LENGTH_LONG).show();
        }

    }
}
