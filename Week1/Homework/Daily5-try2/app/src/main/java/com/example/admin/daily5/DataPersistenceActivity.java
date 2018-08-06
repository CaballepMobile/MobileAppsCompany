package com.example.admin.daily5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.daily5.Activities.ActivityStates;
import com.example.admin.daily5.Activities.ActivityViewModels;

public class DataPersistenceActivity extends AppCompatActivity {

    private TextView tvName;
    private EditText etLastName;
    private EditText etFirstName;
    private Button btnConcatenate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_persistence);

        btnConcatenate = findViewById(R.id.btnConcatenate);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        tvName = findViewById(R.id.tvName);

        btnConcatenate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etFirstName.getText().toString() + " " + etLastName.getText().toString();
                tvName.setText(name);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String name = tvName.getText().toString();

        outState.putString(ActivityStates.DataPersistence.ET_FIRST_NAME, firstName);
        outState.putString(ActivityStates.DataPersistence.ET_LAST_NAME, lastName);
        outState.putString(ActivityStates.DataPersistence.TV_NAME, name);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ActivityViewModels.DataPersistence dataPersistenceModel = new ActivityViewModels.DataPersistence();
        dataPersistenceModel.setFirstName(savedInstanceState.getString(ActivityStates.DataPersistence.ET_FIRST_NAME));
        dataPersistenceModel.setLastName(savedInstanceState.getString(ActivityStates.DataPersistence.ET_LAST_NAME));
        dataPersistenceModel.setName(savedInstanceState.getString(ActivityStates.DataPersistence.TV_NAME));

        etFirstName.setText(dataPersistenceModel.getFirstName());
        etLastName.setText(dataPersistenceModel.getLastName());
        tvName.setText(dataPersistenceModel.getName());

        Toast.makeText(this, "Instance was successfully restored", Toast.LENGTH_SHORT).show();
    }
}
