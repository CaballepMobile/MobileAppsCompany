package com.example.admin.weekendweek3;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.weekendweek3.listsNGrids.RecyclerViewBooksAdapter;
import com.example.admin.weekendweek3.models.Book;
import com.example.admin.weekendweek3.models.Item;
import com.example.admin.weekendweek3.services.BookService;
import com.example.admin.weekendweek3.services.BookServiceHelper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity_LOG";
    private RecyclerView rvBooks;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    public void evtSearch(View view) {
        Log.d(TAG, "evtSearch: ");
        String bookName = etSearch.getText().toString();
        if(bookName.isEmpty() || bookName == null){
            Toast.makeText(this, "Please enter a book name to search.", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d(TAG, "evtSearch: " + bookName);
        List<Item> itemList = getResultItems(bookName);
        fillRecyclerViewList(itemList);
    }

    private void initializeViews(){
        Log.d(TAG, "initializeViews: ");
        rvBooks = findViewById(R.id.rvBooks_MainActivity);
        etSearch = findViewById(R.id.etSearch_MainActivity);
    }

    private void fillRecyclerViewList(List<Item> itemList){
        Log.d(TAG, "fillRecyclerViewList: ");
        rvBooks = findViewById(R.id.rvBooks_MainActivity);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        RecyclerViewBooksAdapter recyclerViewBooksAdapter = new RecyclerViewBooksAdapter(itemList);

        rvBooks.setLayoutManager(layoutManager);
        rvBooks.setAdapter(recyclerViewBooksAdapter);
        rvBooks.setItemAnimator(itemAnimator);
    }

    @SuppressLint("CheckResult")
    private List<Item> getResultItems(String bookName){
        Log.d(TAG, "getResultItems: ");

        BookServiceHelper bookServiceHelper = BookServiceHelper.getINSTANCE();
        List<Item> itemList = new ArrayList<>();

        /*
        bookServiceHelper.getBooks(bookName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(book -> {
            Log.d(TAG, "getResultItems: " + book.getItems().get(0).getVolumeInfo().getTitle());
        }, Throwable::printStackTrace);
        */

        Log.d(TAG, "getResultItems: " + bookName);
        bookServiceHelper.getBooks(bookName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(data ->
                        runOnUiThread(() -> {
                            Log.d(TAG, "getResultItems: " + data.getItems().get(0).getVolumeInfo().getTitle());
                            //Toast.makeText(this, data.getCity().getCountry() + " " + data.getCity().getName(), Toast.LENGTH_SHORT).show();
                        }))
                .subscribe(data -> Log.d(TAG, "MakeOkHttpCallRetrofitRx: "), Throwable::printStackTrace);

        return itemList;
    }
}