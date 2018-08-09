package com.example.admin.roomexample.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.admin.roomexample.data.database.dao.BookDao;
import com.example.admin.roomexample.data.database.entities.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDataBase extends RoomDatabase {

    private static BookDataBase INSTANCE;
    public abstract BookDao bookDao();

    public static BookDataBase getDatabase(Context context){
        if(INSTANCE == null){
            synchronized (BookDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BookDataBase.class, "word_database").build();
                }
            }
        }
        return INSTANCE;
    }
}