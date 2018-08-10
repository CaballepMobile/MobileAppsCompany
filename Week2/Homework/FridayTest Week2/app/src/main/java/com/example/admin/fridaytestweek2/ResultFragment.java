package com.example.admin.fridaytestweek2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ResultFragment extends Fragment {

    TextView tvModel, tvYear, tvType;
    ListView lvCar;
    ArrayList<Car> cars;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvModel = view.findViewById(R.id.tvModel);
        tvType = view.findViewById(R.id.tvType);
        tvYear = view.findViewById(R.id.tvYear);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public void AddCar(Car car){

        cars.add(car); //add to list

        //New inflating
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup mainView = (ViewGroup) inflater.inflate(R.layout.activity_main, null);

        View view = inflater.inflate(R.layout.fragment_result, mainView);
        
        tvModel.setText(car.getModel());
        tvType.setText(car.getType());
        tvYear.setText(car.getYear());

        CarArrayAdapter adapter = new CarArrayAdapter(view.getContext(), cars);
        lvCar.setAdapter(adapter);
    }
}
