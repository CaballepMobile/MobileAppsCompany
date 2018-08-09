package com.example.admin.daily2_week2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable{

    private int EmployeeID;
    private String EmployeeName;
    private String Department;
    private double MonthlySalary;
    private int ManagerID;

    public Employee(int employeeID, String employeeName, String department, double monthlySalary, int managerID) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        Department = department;
        MonthlySalary = monthlySalary;
        ManagerID = managerID;
    }

    public static final String TableName_TAG = "Employee";
    public static final String EmployeeID_TAG = "EmployeeID";
    public static final String EmployeeName_TAG = "EmployeeName";
    public static final String Department_TAG = "Department";
    public static final String MonthlySalary_TAG = "MonthlySalary";
    public static final String ManagerID_TAG = "ManagerID_TAG";

    protected Employee(Parcel in) {
        EmployeeID = in.readInt();
        EmployeeName = in.readString();
        Department = in.readString();
        MonthlySalary = in.readDouble();
        ManagerID = in.readInt();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public double getMonthlySalary() {
        return MonthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        MonthlySalary = monthlySalary;
    }

    public int getManagerID() {
        return ManagerID;
    }

    public void setManagerID(int managerID) {
        ManagerID = managerID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(EmployeeID);
        parcel.writeString(EmployeeName);
        parcel.writeString(Department);
        parcel.writeDouble(MonthlySalary);
        parcel.writeInt(ManagerID);
    }
}