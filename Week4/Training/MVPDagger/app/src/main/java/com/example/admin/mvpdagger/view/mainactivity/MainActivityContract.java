package com.example.admin.mvpdagger.view.mainactivity;

import android.content.Context;

import com.example.admin.mvpdagger.BasePresenter;
import com.example.admin.mvpdagger.BaseView;

public interface MainActivityContract {

    interface View extends BaseView{
        void isPersonSaved(boolean isSaved);
        void sendPerson(String person);
    }

    interface Presenter extends BasePresenter<View> {
        void SavePerson(String person);
        void getPerson();
        void setContext(Context context);
        void attachView(MainActivityContract.View view);
        void removeView();
    }
}
