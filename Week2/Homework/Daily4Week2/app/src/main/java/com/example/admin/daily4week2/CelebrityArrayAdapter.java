package com.example.admin.daily4week2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CelebrityArrayAdapter extends ArrayAdapter<Celebrity> {
    public CelebrityArrayAdapter(@NonNull Context context, ArrayList<Celebrity> celebrities) {
        super(context, 0, celebrities);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Celebrity celebrity = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.options_item, parent, false);
        }
        TextView tvItemCelebrity = convertView.findViewById(R.id.tvItemCelebrity);

        tvItemCelebrity.setText(celebrity.getName());
        return convertView;
    }
}