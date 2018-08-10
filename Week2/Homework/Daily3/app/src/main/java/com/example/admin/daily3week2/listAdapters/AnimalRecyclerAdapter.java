package com.example.admin.daily3week2.listAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.daily3week2.models.Animal;

import java.util.List;

public class AnimalRecyclerAdapter extends RecyclerView.Adapter<AnimalRecyclerAdapter.ViewHolder> {
    List<Animal> animalList;

    public AnimalRecyclerAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvAnimalName;

        public ViewHolder(View itemView){
            super(itemView);
            this.tvAnimalName = itemView.findViewById(R.id.tvAnimalName);
        }
    }
}
