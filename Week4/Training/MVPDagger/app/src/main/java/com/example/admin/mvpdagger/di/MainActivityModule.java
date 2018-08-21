package com.example.admin.mvpdagger.di;

import android.content.Context;

import com.example.admin.mvpdagger.di.scopes.Activity;
import com.example.admin.mvpdagger.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Activity
    @Provides
    MainActivityPresenter providesMainActivityPresenter(Context context){

        return new MainActivityPresenter();
    }
}
