package com.example.admin.recyclerviewexample;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CelebrityRecyclerAdapter extends RecyclerView.Adapter<CelebrityRecyclerAdapter.ViewHolder> {

    private static final String TAG = "[!] - RecyclerAdapter";
    List<Celebrity> celebrities = new ArrayList<>();

    public CelebrityRecyclerAdapter(List<Celebrity> celebrities){
        this.celebrities = celebrities;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvCelebrityName, tvCelebrityAge, tvCelebrityWeight;

        public ViewHolder(View itemView){
            super(itemView);
            this.tvCelebrityName = itemView.findViewById(R.id.tvCelebName);
            this.tvCelebrityAge = itemView.findViewById(R.id.tvCelebAge);
            this.tvCelebrityWeight = itemView.findViewById(R.id.tvCelebWeight);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celebrity_recycler_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Celebrity celebrityTemp = celebrities.get(position);
        if(celebrityTemp != null){
            holder.tvCelebrityName.setText(celebrityTemp.getName());
            holder.tvCelebrityAge.setText(String.valueOf(celebrityTemp.getAge()));
            holder.tvCelebrityWeight.setText(String.valueOf(celebrityTemp.getWeight()));
        }
    }

    @Override
    public int getItemCount() {
        return celebrities.size();
    }
}