package com.example.admin.mvvmexample;

import android.databinding.ObservableField;

import org.json.JSONException;

public class UserViewModel extends BaseViewModel<MainActivity> {

    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableField<String> favoriteAnimal = new ObservableField<>();
    public final ObservableField<String> age = new ObservableField<>();
    public static final String TAG = "UserViewModel_LOG";
    private Repo repo;

    public UserViewModel(MainActivity activity) {
        super(activity);
        repo = new UserRepo(activity);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
        try {
            Person person = repo.getUser();
            if (!person.getFirstName().equals("Not found")) {
                firstName.set(person.getLastName());
                lastName.set(person.getLastName());
                favoriteAnimal.set(person.getFavoriteAnimal());
                age.set(String.valueOf(person.getAge()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        storeUser(); //Guaranteed to be call even if the app crashes
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    public void storeUser() {
        Person person = new Person(
                firstName.get(),
                lastName.get(),
                favoriteAnimal.get(),
                Integer.parseInt(age.get())
        );
        repo.saveUser(person);
    }
}
