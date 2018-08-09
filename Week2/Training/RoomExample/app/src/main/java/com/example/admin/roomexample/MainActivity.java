package com.example.admin.roomexample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.admin.roomexample.data.database.BookDataBase;
import com.example.admin.roomexample.data.database.entities.Book;


import io.reactivex.Completable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private EditText etBookISBN, etBookAuthor, etBookName;
    private BookDataBase bookDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBookISBN = findViewById(R.id.etBookISBN);
        etBookAuthor = findViewById(R.id.etBookAuthor);
        etBookName = findViewById(R.id.etBookName);
        bookDataBase = BookDataBase.getDatabase(this);

    }

    @SuppressLint("CheckResult")
    public void evtSaveBook(View view) {
        Book book = new Book(etBookISBN.getText().toString(), etBookName.getText().toString(), etBookAuthor.getText().toString());

        Completable.fromAction(() ->
            bookDataBase.bookDao().saveBook(book))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Log.d("MyTAG", "evtSaveBook: "),
                        Throwable::printStackTrace);

    }

    public void evtGetAllBooks(View view) {
        bookDataBase.bookDao()
                .GetAllBooks()
                .subscribeOn(Schedulers.io())
                .flattenAsObservable(list -> list)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Book book) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
