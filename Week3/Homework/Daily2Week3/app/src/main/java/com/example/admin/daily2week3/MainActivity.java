package com.example.admin.daily2week3;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etLastName, etAge, etGenre;
    Button btnSavePerson, btnGoToPeopleActivity;

    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        InitializeViews();

        myBroadcastReceiver = new MyBroadcastReceiver();
    }

    private void InitializeViews() {

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);
        etGenre = findViewById(R.id.etGenre);

        //btnSavePerson.setOnClickListener(view -> SavePerson());

        //btnGoToPeopleActivity.setOnClickListener(view -> GoToContactList());
    }

    public void SavePerson(View view) {
        Person person = new Person(etName.getText().toString(), etLastName.getText().toString(), etAge.getText().toString(), etGenre.getText().toString());
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.SaveNewPerson(person);

        Intent intent = new Intent();
        intent.setAction(Constants.MY_BROADCAST_RECEIVER_KEY);
        intent.putExtra("data", person);
        sendBroadcast(intent);
    }

    public void GoToContactList(View view) {
        Intent intent = new Intent(this, PeopleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.MY_BROADCAST_RECEIVER_KEY);
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReceiver);
    }
}