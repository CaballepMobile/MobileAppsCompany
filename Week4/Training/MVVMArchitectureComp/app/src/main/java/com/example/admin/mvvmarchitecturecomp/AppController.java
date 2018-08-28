package com.example.admin.mvvmarchitecturecomp;

import android.app.Application;

import com.example.admin.mvvmarchitecturecomp.di.DaggerMainComponent;
import com.example.admin.mvvmarchitecturecomp.di.MainComponent;
import com.example.admin.mvvmarchitecturecomp.di.MainModule;

public class AppController extends Application {
    private MainComponent mainComponent;

    public MainComponent getAppComponent() {
        if (mainComponent == null)
            mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
        return mainComponent;
    }
}
