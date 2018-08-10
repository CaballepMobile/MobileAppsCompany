package com.example.admin.rxjavapractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView tvCount, tvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        tvTimer = findViewById(R.id.tvTimer);

        Observable.timer(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(number -> Toast.makeText(this, number + "Missipi", Toast.LENGTH_SHORT).show())
                //.unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(aLong -> aLong*2)
                .observeOn(AndroidSchedulers.mainThread())
                /*
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return aLong*2;
                    }
                })
                */
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        tvCount.setText(String.valueOf(aLong));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
                    }
                });

                Observable.zip(Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                        Observable.interval(1, TimeUnit.SECONDS),
                        (integer, aLong) -> integer)
                        .subscribeOn(Schedulers.io())
                        //.take(1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Integer integer) {
                                tvTimer.setText(String.valueOf(integer));
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(MainActivity.this, "Completed!", Toast.LENGTH_SHORT).show();
                            }
                        });
    }
}
