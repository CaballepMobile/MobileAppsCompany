package com.example.admin.restcallsexample;

import com.google.gson.annotations.SerializedName;

public class Person {
    private String name;
    private int age;
    @SerializedName("weight") //This attibute will be maped as weight
    private int weight_wrong;
    private String nationality;

    public Person(String name, int age, int weight, String nationality) {
        this.name = name;
        this.age = age;
        this.weight_wrong = weight;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight_wrong;
    }

    public void setWeight(int weight) {
        this.weight_wrong = weight;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight_wrong +
                ", nationality=" + nationality +
                '}';
    }
}