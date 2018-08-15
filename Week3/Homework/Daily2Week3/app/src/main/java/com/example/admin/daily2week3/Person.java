package com.example.admin.daily2week3;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{

    private String Name;
    private String LastName;
    private String Age;
    private String Genre;

    public Person(){

    }

    public Person(String name, String lastName, String age, String genre) {
        Name = name;
        LastName = lastName;
        Age = age;
        Genre = genre;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(LastName);
        parcel.writeString(Age);
        parcel.writeString(Genre);
    }

    protected Person(Parcel in) {
        Name = in.readString();
        LastName = in.readString();
        Age = in.readString();
        Genre = in.readString();
    }
}
