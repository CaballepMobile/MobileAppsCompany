package com.example.admin.week5codingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.week5codingchallenge.models.PlaceForecastDatum;
import com.example.admin.week5codingchallenge.network.PlaceForecastHelper;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        PlaceForecastHelper placeForecastHelper = PlaceForecastHelper.getINSTANCE();

        List<PlaceForecastDatum> placeForecastDatumList = placeForecastHelper.getAllPlaceForecasts();

        for (PlaceForecastDatum item : placeForecastDatumList){
            Log.d(TAG, "onCreate: " + item.getConsolidatedWeather().get(1).getWeatherStateName());
        }

        Log.d(TAG, "onCreate: Service worked out and list is fill now!");

        Gson gson = new Gson();
        String word = gson.toJson(placeForecastDatumList);

        Log.d(TAG, "onCreate: Data as Json String: " + word);
    }
}