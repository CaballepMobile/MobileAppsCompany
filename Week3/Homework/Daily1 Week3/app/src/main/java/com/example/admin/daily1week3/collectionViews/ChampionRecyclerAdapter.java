package com.example.admin.daily1week3.collectionViews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.daily1week3.R;
import com.example.admin.daily1week3.models.Champion;

import java.util.List;

public class ChampionRecyclerAdapter extends RecyclerView.Adapter<ChampionRecyclerAdapter.ViewHolder> {

    private TextView tvChampionName, tvChampionRole, tvChampionLevel;
    private ImageView ivChampionPicture;

    List<Champion> champions;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView){
            super(itemView);

            tvChampionName = itemView.findViewById(R.id.tvChampionName);
            tvChampionRole = itemView.findViewById(R.id.tvChampionRole);
            tvChampionLevel = itemView.findViewById(R.id.tvChampionLevel);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.champion_recycler_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}