package com.example.admin.daily2_week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.daily2_week2.models.Employee;

public class MainActivity extends AppCompatActivity {

    EditText etEmployeeName, etDepartment, etMonthlySalary, etManagerId;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmployeeName = findViewById(R.id.etEmployeeName);
        etDepartment = findViewById(R.id.etDepartment);
        etMonthlySalary = findViewById(R.id.etMonthlySalary);
        etManagerId = findViewById(R.id.etManagerId);

        btnSave = findViewById(R.id.btnSave);
    }

    public void evtEmployee(View view) {
        if(view.getId() == R.id.btnSave){
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.SaveNewEmployee(
                    new Employee(
                            etEmployeeName.getText().toString(),
                            etDepartment.getText().toString(),
                            Double.parseDouble(etMonthlySalary.getText().toString()),
                            Integer.parseInt(etManagerId.getText().toString())
                    )
            );
        }
        if(view.getId() == R.id.btnSeeEmployees){
            Intent intent = new Intent(this, EmployeeListActivity.class);
            startActivity(intent);
        }
    }
}
