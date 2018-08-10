package com.example.admin.daily2_week2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.daily2_week2.models.Employee;

import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private ListView lvEmployee;
    private TextView tvTemporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        tvTemporal = findViewById(R.id.tvTemporal);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Employee> employees = databaseHelper.getEmployees();

        String result = "";
        for (Employee employee : employees){
            result += employee.getEmployeeID() + ", " + employee.getEmployeeName() + ", " + employee.getDepartment() + ", " + employee.getMonthlySalary() + ", " + employee.getManagerID() + "\n";
        }

        tvTemporal.setText(result);
    }
}
