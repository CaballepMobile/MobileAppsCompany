package com.example.admin.daily2week3;

import android.provider.Contacts;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PeopleRecyclerAdapter extends RecyclerView.Adapter<PeopleRecyclerAdapter.ViewHolder> {

    private static final String TAG = "PeopleRecyclerView_LOGTAG";
    List<Person> people= new ArrayList<>();

    public PeopleRecyclerAdapter(List<Person> people){
        this.people = people;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvName, tvLastName, tvAge, tvGenre;

        public ViewHolder(View itemView){
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName_rv_people_item);
            this.tvLastName = itemView.findViewById(R.id.tvLastName_rv_people_item);
            this.tvAge = itemView.findViewById(R.id.tvAge_rv_people_item);
            this.tvGenre = itemView.findViewById(R.id.tvGenre_rv_people_item);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_recycler_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Person newPerson = people.get(position);
        if(newPerson != null){
            holder.tvName.setText(newPerson.getName());
            holder.tvLastName.setText(String.valueOf(newPerson.getLastName()));
            holder.tvAge.setText(String.valueOf(newPerson.getAge()));
            holder.tvGenre.setText(String.valueOf(newPerson.getGenre()));
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}