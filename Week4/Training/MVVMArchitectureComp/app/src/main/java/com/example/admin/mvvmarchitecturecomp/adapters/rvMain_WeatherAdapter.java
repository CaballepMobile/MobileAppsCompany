package com.example.admin.mvvmarchitecturecomp.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.mvvmarchitecturecomp.R;
import com.example.admin.mvvmarchitecturecomp.data.remote.models.Weather;
import com.example.admin.mvvmarchitecturecomp.databinding.RecyclerViewItemBinding;

import java.util.List;

public class rvMain_WeatherAdapter extends RecyclerView.Adapter<rvMain_WeatherAdapter.ViewHolder> {

    private List<List<Weather>> weatherList;
    private Context context;

    public rvMain_WeatherAdapter(List<List<Weather>> weatherList, Context context) {
        this.weatherList = weatherList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_item, parent, false);
        return new ViewHolder(binding);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather temp = weatherList.get(position).get(0);
        String[] dateNTime = temp.getDate().split(" ");
        holder.binding.tvMain.setText(String.format(context.getResources().getString(R.string.all_weatherMain), temp.getMain(), dateNTime[0], dateNTime[1]));
        holder.binding.tvDescription.setText(temp.getDescription());
        String imageUrl = "";
        String finalImageUrl = String.format(imageUrl, temp.getIcon());
        Glide.with(context).load(finalImageUrl).into(holder.binding.ivIcon);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewItemBinding binding;

        public ViewHolder(RecyclerViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
