package com.example.admin.daily4week3.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.daily4week3.R;

import java.util.ArrayList;
import java.util.List;

public class LocationWeatherRecyclerAdapter extends RecyclerView.Adapter<LocationWeatherRecyclerAdapter.ViewHolder> {

    private Context context;
    private static final String TAG = "LocationWeatherRecyclerAdapter_LOG";
    java.util.List<com.example.admin.daily4week3.models.List> list = new ArrayList<>();

    private TextView tvMainWeather, tvTemperature;
    private ImageView ivTemperature;

    public LocationWeatherRecyclerAdapter(java.util.List<com.example.admin.daily4week3.models.List> list){
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(View itemView){
            super(itemView);
            tvMainWeather = itemView.findViewById(R.id.tvMainWeather);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);
            ivTemperature = itemView.findViewById(R.id.ivWeather);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleriew_item_city_weather, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        com.example.admin.daily4week3.models.List listItem = list.get(position);
        if(listItem != null){

            //String icon = listItem.getWeather().get(0).getIcon();
            String weather = listItem.getWeather().get(0).getMain();
            String temperature = listItem.getMain().getTemp().toString();

            tvMainWeather.setText(weather);
            tvTemperature.setText(temperature);
            //ivTemperature.setImageDrawable(context.getDrawable(context.getResources().getIdentifier("i"+icon, "drawable", context.getPackageName())));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}