package com.example.admin.roomexample.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.admin.roomexample.data.database.entities.Book;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface BookDao {

    @Insert
    void saveBook(Book book);

    @Query("SELECT * FROM Book")
    Single<List<Book>> GetAllBooks();
}
