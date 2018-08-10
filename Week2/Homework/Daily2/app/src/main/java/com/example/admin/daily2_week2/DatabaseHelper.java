package com.example.admin.daily2_week2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.daily2_week2.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "MyDatabase";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private String GetDropAllTablesString(){
        String dropQuery = "DROP TABLE IF EXISTS " + Employee.TableName_TAG;
        return dropQuery;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTablesString = GetDropAllTablesString();
        sqLiteDatabase.execSQL(dropTablesString);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + Employee.TableName_TAG + "("
                + Employee.ManagerID_TAG + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Employee.EmployeeName_TAG + " TEXT,"
                + Employee.MonthlySalary_TAG + " TEXT,"
                + Employee.Department_TAG + " TEXT,"
                + Employee.ManagerID_TAG + " REAL"
                + ")";
        sqLiteDatabase.execSQL(createTable);
    }

    public void SaveNewEmployee(Employee employee){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Employee.EmployeeName_TAG, employee.getEmployeeName());
        contentValues.put(Employee.MonthlySalary_TAG, employee.getMonthlySalary());
        contentValues.put(Employee.Department_TAG, employee.getMonthlySalary());
        contentValues.put(Employee.ManagerID_TAG, employee.getManagerID());
        int result = (int)database.insert(Employee.TableName_TAG, null, contentValues);
    }

    public List<Employee> getEmployees(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "SELECT * FROM " + Employee.TableName_TAG;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        List<Employee> employees = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                Employee contact = new Employee(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getInt(4));
                employees.add(contact);
            }while(cursor.moveToNext());
        }

        cursor.close();
        return employees;
    }
}