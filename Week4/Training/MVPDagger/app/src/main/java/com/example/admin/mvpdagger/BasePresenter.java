package com.example.admin.mvpdagger;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void removeView();
}
