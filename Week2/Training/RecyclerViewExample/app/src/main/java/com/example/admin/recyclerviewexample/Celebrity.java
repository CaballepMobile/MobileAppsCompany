package com.example.admin.recyclerviewexample;

public class Celebrity {
    private String Name;
    private int Age;
    private int Weight;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public Celebrity(String name, int age, int weight) {
        Name = name;
        Age = age;
        Weight = weight;
    }
}