package com.example.admin.mvvmexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class UserRepo implements Repo {

    public static final String TAG = "UserRepo_LOG";
    Context context;

    public UserRepo(Context context) {
        this.context = context;
    }

    @Override
    public Person getUser() throws JSONException {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.KEY.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String jsonPerson = sharedPreferences.getString(Constants.KEY.PERSON_KEY, "");
        Person person;
        if(!jsonPerson.isEmpty()) {
            JSONObject jsonObject = new JSONObject(jsonPerson);
            String firstName = jsonObject.getString("firstName");
            String lastName = jsonObject.getString("lastName");
            String favoriteAnimal = jsonObject.getString("favoriteAnimal");
            int age = jsonObject.getInt("age");

            person = new Person(
                    firstName, lastName, favoriteAnimal, age
            );
        }else{
            person = new Person("Not found", "", "", 0);
        }

        Log.d(TAG, "getUser: ");
        return person;
    }

    @Override
    public void saveUser(Person person) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("firstName", person.getFirstName());
            jsonObject.put("lastName", person.getLastName());
            jsonObject.put("favoriteAnimal", person.getFavoriteAnimal());
            jsonObject.put("age", person.getAge());
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.KEY.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Constants.KEY.PERSON_KEY, jsonObject.toString());
            editor.commit();
            Log.d(TAG, "sendPerson: " + jsonObject.toString());
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}
