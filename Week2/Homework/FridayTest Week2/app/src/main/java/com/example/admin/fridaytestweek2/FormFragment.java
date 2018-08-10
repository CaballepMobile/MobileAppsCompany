package com.example.admin.fridaytestweek2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class FormFragment extends Fragment {

    EditText etModel, etYear, etType;
    Button btnSubmit;
    Car car;

    public interface OnFormFragmentInteractionListener {
        void OnFormFragmentInteractionListener(Car car);
    }

    private FormFragment.OnFormFragmentInteractionListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FormFragment.OnFormFragmentInteractionListener) {
            mListener = (FormFragment.OnFormFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener.");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_form, container, false);
        etModel = view.findViewById(R.id.etModel);
        etType = view.findViewById(R.id.etType);
        etYear = view.findViewById(R.id.etYear);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int newId = new Random().nextInt(50000)+1;

                Car car = new Car(newId, etModel.getText().toString(), etType.getText().toString(), etYear.getText().toString());
                etModel.setText("");
                etType.setText("");
                etYear.setText("");
                mListener.OnFormFragmentInteractionListener(car);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //lvCar = view.findViewById(R.id.lvCar);
        //tvModel = view.findViewById(R.id.tvModel);
        //tvType = view.findViewById(R.id.tvType);
        //tvYear = view.findViewById(R.id.tvYear);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
