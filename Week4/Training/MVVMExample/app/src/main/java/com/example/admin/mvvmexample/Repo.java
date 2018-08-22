package com.example.admin.mvvmexample;

import org.json.JSONException;
import org.json.JSONObject;

public interface Repo {
    Person getUser() throws JSONException;
    void saveUser(Person person);

}
