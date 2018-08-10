package com.example.admin.daily3week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        Intent intent = getIntent();
        int categoryId = intent.getIntExtra("CATEGORY_KEY", 0);

        Toast.makeText(this, categoryId + "", Toast.LENGTH_SHORT).show();
    }
}
