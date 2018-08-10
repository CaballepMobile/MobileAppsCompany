package com.example.admin.daily3week2.models;

public class Category {

    public static final String TableName_TAG = "Category";
    public static final String CategoryId_TAG = "CategoryId";
    public static final String CategoryName_TAG = "CategoryName";

    private int CategoryId;
    private String CategoryName;

    public Category(String categoryName) {
        CategoryName = categoryName;
    }

    public Category(int categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}