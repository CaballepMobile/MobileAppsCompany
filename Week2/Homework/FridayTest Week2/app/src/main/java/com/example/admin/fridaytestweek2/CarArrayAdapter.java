package com.example.admin.fridaytestweek2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CarArrayAdapter extends ArrayAdapter<Car> {
    public CarArrayAdapter(@NonNull Context context, ArrayList<Car> cars) {
        super(context, 0, cars);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Car car = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.car_list_item, parent, false);
        }
        TextView tvModel = convertView.findViewById(R.id.tvModel);
        TextView tvType = convertView.findViewById(R.id.tvType);
        TextView tvYear = convertView.findViewById(R.id.tvYear);

        tvModel.setText(car.getModel());
        tvType.setText(car.getType());
        tvYear.setText(car.getYear());

        return convertView;
    }
}
