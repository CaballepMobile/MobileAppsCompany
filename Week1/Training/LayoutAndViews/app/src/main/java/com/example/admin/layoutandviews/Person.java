package com.example.admin.layoutandviews;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    String gender;

    public Person(String _name, String _gender){
        this.name = _name;
        this.gender = _gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}