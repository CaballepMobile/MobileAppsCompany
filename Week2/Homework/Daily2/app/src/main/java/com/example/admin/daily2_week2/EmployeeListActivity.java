package com.example.admin.daily2_week2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.admin.daily2_week2.models.Employee;

import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private RecyclerView rvEmployee;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private TextView tvTemporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        tvTemporal = findViewById(R.id.tvTemporal);
        Intent intent = getIntent();
        List<Employee> employees = intent.getParcelableArrayListExtra("KEY");

        String result = "";
        for (Employee employee : employees){
            result += employee.getEmployeeID() + ", " + employee.getEmployeeName() + ", " + employee.getDepartment() + ", " + employee.getMonthlySalary() + ", " + employee.getManagerID() + "\n";
        }

        tvTemporal.setText(result);
    }
}
