package com.example.admin.daily2week3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DataBaseHelper";

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "MyDataBase";

    public static final String TABLE_NAME = "Contacts";
    public static final String PERSON_NAME = "Name";
    public static final String PERSON_LASTNAME = "Number";
    public static final String PERSON_AGE = "Name";
    public static final String PERSON_GENRE = "Number";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + PERSON_NAME + " TEXT,"
                + PERSON_LASTNAME + " TEXT,"
                + PERSON_AGE + " TEXT,"
                + PERSON_GENRE + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);

        InsertDummies();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void SaveNewPerson(Person person){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_NAME, person.getName());
        contentValues.put(PERSON_LASTNAME, person.getLastName());
        contentValues.put(PERSON_AGE, person.getAge());
        contentValues.put(PERSON_GENRE, person.getGenre());
        int result = (int)database.insert(TABLE_NAME, null, contentValues);

        Log.d(TAG, "SaveNewPerson: ");
    }

    public List<Person> GetPeople(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        List<Person> persons = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                Person person = new Person(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                persons.add(person);
            }while(cursor.moveToNext());
        }

        cursor.close();
        return persons;
    }

    private void InsertDummies(){
        SaveNewPerson(new Person("Marco", "Lebrints", "24", "Male"));
        SaveNewPerson(new Person("Catlyn", "Gonsso", "45", "Female"));
        SaveNewPerson(new Person("Azir", "Solaris", "13", "Male"));
        SaveNewPerson(new Person("Alejandra", "Mendivil", "25", "Female"));
        SaveNewPerson(new Person("Miriam", "Demacia", "19", "Female"));
        SaveNewPerson(new Person("Cesar", "Iladins", "31", "Male"));
    }
}