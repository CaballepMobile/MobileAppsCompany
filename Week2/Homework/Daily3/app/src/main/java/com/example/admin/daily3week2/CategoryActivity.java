package com.example.admin.daily3week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.daily3week2.listAdapters.CategoryListAdapter;
import com.example.admin.daily3week2.models.Category;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    ListView lvCategories;
    Category category;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        lvCategories = findViewById(R.id.lvCategories);
        lvCategories.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        InitData();

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(this, R.layout.catergories_list_item, categoryList);
        lvCategories.setAdapter(categoryListAdapter);

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //int categoryId = adapterView.getSelectedView().;

                Intent intent = new Intent(getApplicationContext(), AnimalActivity.class);
                intent.putExtra("CATEGORY_KEY", category.getCategoryId());
                startActivity(intent);
            }
        });
    }

    private void InitData(){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        categoryList = databaseHelper.GetCategories();
    }
}