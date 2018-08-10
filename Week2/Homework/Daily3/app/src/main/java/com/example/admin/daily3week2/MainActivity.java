package com.example.admin.daily3week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.daily3week2.listAdapters.CategoryListAdapter;
import com.example.admin.daily3week2.models.Category;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(this, R.layout.catergories_list_item, categoryList);
        //categoryListAdapter.
    }

    public void evtGoToCategoriesActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        startActivity(intent);
    }
}
