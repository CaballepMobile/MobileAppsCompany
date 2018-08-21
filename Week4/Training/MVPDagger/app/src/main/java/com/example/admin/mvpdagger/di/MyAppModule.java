package com.example.admin.mvpdagger.di;

import android.content.Context;

import com.example.admin.mvpdagger.di.scopes.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class MyAppModule {
    Context context;

    public MyAppModule(Context context) {
        this.context = context;
    }

    @Application
    @Provides
    Context provideContext(){
        return context;
    }
}
