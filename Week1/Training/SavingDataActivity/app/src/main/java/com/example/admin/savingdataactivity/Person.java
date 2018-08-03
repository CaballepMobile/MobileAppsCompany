package com.example.admin.savingdataactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{

    public Person(String name, String gender) {
        Name = name;
        Gender = gender;
    }

    private String Name;
    private String Gender;

    protected Person(Parcel in) {
        Name = in.readString();
        Gender = in.readString();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Gender);
    }
}