package com.example.admin.daily2_week2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.daily2_week2.models.Employee;

public class EmployeeDetailActivity extends AppCompatActivity {

    TextView tvEmployeeId, tvEmployeeName, tvMonthlySalary, tvManagerId, tvDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        Intent intent = getIntent();
        Employee employee = (Employee) intent.getParcelableExtra("KEY");
        FillViews(employee);
    }

    private void FillViews(Employee employee){
        tvEmployeeId = findViewById(R.id.tvEmployeeId);
        tvEmployeeName = findViewById(R.id.tvEmployeeName);
        tvMonthlySalary = findViewById(R.id.tvMonthlySalary);
        tvManagerId = findViewById(R.id.tvManagerId);
        tvDepartment = findViewById(R.id.tvDepartment);

        tvEmployeeId.setText(String.valueOf(employee.getEmployeeID()));
        tvEmployeeName.setText(employee.getEmployeeName());
        tvMonthlySalary.setText(String.valueOf(employee.getMonthlySalary()));
        tvManagerId.setText(String.valueOf(employee.getManagerID()));
        tvDepartment.setText(employee.getDepartment());
    }
}