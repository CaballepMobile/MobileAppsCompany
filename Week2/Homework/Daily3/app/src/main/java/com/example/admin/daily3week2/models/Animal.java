package com.example.admin.daily3week2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    public static final String TableName_TAG = "Animal";
    public static final String AnimalId_TAG = "AnimalId";
    public static final String Name_TAG = "Name";
    public static final String Description_TAG = "Description";
    public static final String PicturePath_TAG = "PicturePath";
    public static final String SoundPath_TAG = "SoundPath";
    public static final String CategoryId_TAG = "CategoryId";

    private int AnimalId;
    private String Name;
    private String Description;
    private String PicturePath;
    private String SoundPath;
    private int CategoryId;

    public Animal(String name, String description, String picturePath, String soundPath, int categoryId) {
        Name = name;
        Description = description;
        PicturePath = picturePath;
        SoundPath = soundPath;
        CategoryId = categoryId;
    }

    public Animal(int animalId, String name, String description, String picturePath, String soundPath, int categoryId) {
        AnimalId = animalId;
        Name = name;
        Description = description;
        PicturePath = picturePath;
        SoundPath = soundPath;
        CategoryId = categoryId;
    }

    public int getAnimalId() {
        return AnimalId;
    }

    public void setAnimalId(int animalId) {
        AnimalId = animalId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicturePath() {
        return PicturePath;
    }

    public void setPicturePath(String picturePath) {
        PicturePath = picturePath;
    }

    public String getSoundPath() {
        return SoundPath;
    }

    public void setSoundPath(String soundPath) {
        SoundPath = soundPath;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
