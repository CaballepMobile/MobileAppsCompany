package com.example.admin.weekendweek3.services;

import android.util.Log;

import com.example.admin.weekendweek3.constants.ConstantsGoogleBookAPI;
import com.example.admin.weekendweek3.models.Book;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookServiceHelper {

    public static final String TAG = "BookServiceHelper_LOG";
    private OkHttpClient okHttpClient;
    private static BookServiceHelper INSTANCE;

    private BookServiceHelper(){

        Log.d(TAG, "BookServiceHelper: ");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static BookServiceHelper getINSTANCE(){

        Log.d(TAG, "getINSTANCE: ");
        if (INSTANCE != null){
            INSTANCE = new BookServiceHelper();
        }
        return INSTANCE;
    }

    public Single<Book> getBooks(String bookName){

        Log.d(TAG, "getBooks: ");
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ConstantsGoogleBookAPI.BaseURL)
                .build();

        BookService bookService = retrofit.create(BookService.class);

        return bookService.getBooks(bookName);
    }
}
