package com.example.admin.webviewsandsqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "[!] - DataBaseHelper";

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "MyDataBase";

    public static final String TABLE_NAME = "Contacts";
    public static final String CONTACT_NAME = "Name";
    public static final String CONTACT_NUMBER = "Number";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + CONTACT_NAME + " TEXT,"
                + CONTACT_NUMBER + " TEXT PRIMARY KEY"
                + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void SaveNewContact(MyContact contact){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_NAME, contact.getName());
        contentValues.put(CONTACT_NUMBER, contact.getNumber());
        int result = (int)database.insert(TABLE_NAME, null, contentValues);

        Log.d(TAG, "SaveNewContact: ");
    }

    public List<MyContact> getContacts(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        List<MyContact> contacts = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                MyContact contact = new MyContact(cursor.getString(0), cursor.getString(1));
                contacts.add(contact);
            }while(cursor.moveToNext());
        }

        cursor.close();
        return contacts;
    }
}