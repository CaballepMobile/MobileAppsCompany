package com.example.admin.savingdataactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";
    EditText editText;
    TextView textView;
    Button btnChangeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etName);
        textView = findViewById(R.id.tvName);
        btnChangeText = findViewById(R.id.btnChangeText);

        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                textView.setText(data);
            }
        });

        Log.d(TAG, "onCreate: ");
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

    public void DoSomething(View view) {

        switch (view.getId()){

            case R.id.btnGoToSecond:

                List<Person> personList = new ArrayList<>();

                personList.add(new Person("Eren", "Male"));
                personList.add(new Person("Levi", "Male"));
                personList.add(new Person("Annie", "Female"));

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putParcelableArrayListExtra("persons", (ArrayList<? extends Parcelable>) personList);
                startActivity(intent);
                break;

            case R.id.btnShareData:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
        }
    }

    public void ChangeText(View view) {
        String data = editText.getText().toString();
        textView.setText(data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        String data = textView.getText().toString();
        outState.putString("data", data);
        super.onSaveInstanceState(outState);
        
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        Log.d(TAG, "onRestoreInstanceState: ");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        textView.setText(savedInstanceState.getString("data"));
        super.onRestoreInstanceState(savedInstanceState);
    }
}