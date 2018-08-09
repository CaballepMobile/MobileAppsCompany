package com.example.admin.recyclerviewexample;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CelebrityListAdapter extends ArrayAdapter<Celebrity>
{
    List<Celebrity> celebrities = new ArrayList<>();

    public CelebrityListAdapter(@NonNull Context context, int resource, List<Celebrity> celebrityList){
        super(context, resource, celebrityList);
        this.celebrities = celebrityList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Celebrity celebrityTemp = celebrities.get(position);
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.celebrity_list_item, parent, false);
            viewHolder.name = convertView.findViewById(R.id.tvCelebrityName);
            viewHolder.age = convertView.findViewById(R.id.tvCelebrityAge);
            viewHolder.weight = convertView.findViewById(R.id.tvCelebrityWeight);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(celebrityTemp.getName());
        viewHolder.age.setText(String.valueOf(celebrityTemp.getAge()));
        viewHolder.weight.setText(String.valueOf(celebrityTemp.getWeight()));
        return convertView;
    }

    public static class ViewHolder{
        TextView name, age, weight;
    }
}
