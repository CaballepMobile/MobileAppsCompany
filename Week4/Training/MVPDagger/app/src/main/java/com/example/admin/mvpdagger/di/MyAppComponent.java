package com.example.admin.mvpdagger.di;

import com.example.admin.mvpdagger.MyApp;
import com.example.admin.mvpdagger.di.scopes.Application;

import dagger.Component;

@Application
@Component(modules = MyAppModule.class)
public interface MyAppComponent {
    MainActivityComponent newMainActivityComponent(MainActivityModule mainActivityModule);
    void inject(MyApp myApp);
}
