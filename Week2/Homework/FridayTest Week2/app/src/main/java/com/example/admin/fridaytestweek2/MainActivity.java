package com.example.admin.fridaytestweek2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FormFragment.OnFormFragmentInteractionListener {

    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFragment = new ResultFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.flResult, resultFragment, "ResultFragment")
                .addToBackStack("ResultFragment")
                .commit();
    }

    @Override
    public void OnFormFragmentInteractionListener(Car car) {
        resultFragment.AddCar(car); //Send new car and try inflating it
    }

}