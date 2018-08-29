package com.example.admin.week5codingchallenge.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.week5codingchallenge.R;
import com.example.admin.week5codingchallenge.models.PlaceForecastDatum;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private static final String TAG = "[!] - RecyclerAdapter";
    List<PlaceForecastDatum> placeForecasts = new ArrayList<>();

    public ForecastAdapter(List<PlaceForecastDatum> placeForecasts){
        this.placeForecasts = placeForecasts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        PlaceForecastDatum placeForecastDatumTemporal = placeForecasts.get(position);
        if(placeForecastDatumTemporal != null){
            Log.d(TAG, "onBindViewHolder: " + placeForecastDatumTemporal.getConsolidatedWeather().get(1).getWeatherStateName());
        }
    }

    @Override
    public int getItemCount() {
        return placeForecasts.size();
    }
}
