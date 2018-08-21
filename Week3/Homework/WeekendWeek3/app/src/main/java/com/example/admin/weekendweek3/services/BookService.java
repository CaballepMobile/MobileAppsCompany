package com.example.admin.weekendweek3.services;

import com.example.admin.weekendweek3.models.Book;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {

    @GET("books/v1/volumes")
    Single<Book> getBooks(@Query("q") String bookName);
}

//https://www.googleapis.com/books/v1/volumes?q=harry