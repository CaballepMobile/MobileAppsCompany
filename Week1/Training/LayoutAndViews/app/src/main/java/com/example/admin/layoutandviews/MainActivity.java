package com.example.admin.layoutandviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "Main Activity";
    private EditText etNumber1, etNumber2;
    private TextView tvName;
    private Button btnName;
    private EditText etPersonName;
    private EditText etPerosnGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnName = findViewById(R.id.btnDoMagic);
        tvName = findViewById(R.id.tvName);

        etPersonName = findViewById(R.id.etPersonName);
        etPerosnGender = findViewById(R.id.etPersonGender);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int etNum1 = Integer.parseInt(etNumber1.getText().toString());
                int etNum2 = Integer.parseInt(etNumber2.getText().toString());

                tvName.setText(String.valueOf(etNum1 + etNum2));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart: ");
    }

    public void goToSecond(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        String value = etNumber1.getText().toString();
        intent.setAction("sendingValue");
        intent.putExtra(getString(R.string.KEY_VALUE1), value);
        startActivity(intent);
    }

    public void passPersonToSecond(View view) {

        String personName = etPersonName.getText().toString();
        String personGenre = etPerosnGender.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        Person person = new Person(personName, personGenre);
        intent.setAction("sendingPerson");
        intent.putExtra("person", person);
        startActivity(intent);
    }
}