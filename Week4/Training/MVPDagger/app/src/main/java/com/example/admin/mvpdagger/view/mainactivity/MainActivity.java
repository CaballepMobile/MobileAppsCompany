package com.example.admin.mvpdagger.view.mainactivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.admin.mvpdagger.R;
import com.example.admin.mvpdagger.di.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    public static final String TAG = "MainActivity_TAG";

    @Inject
    MainActivityPresenter presenter;

    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //presenter = new MainActivityPresenter();
        DaggerMainActivityComponent.create().Inject(this);
        presenter.attachView(this);
        presenter.setContext(this);
    }

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d(TAG, "isPersonSaved: ");
    }

    @Override
    public void sendPerson(String person) {
        Log.d(TAG, "sendPerson: ");
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: ");
    }

    public void evtSavePerson(View view) {
        presenter.SavePerson("John Snow");
        presenter.getPerson();
    }
}
