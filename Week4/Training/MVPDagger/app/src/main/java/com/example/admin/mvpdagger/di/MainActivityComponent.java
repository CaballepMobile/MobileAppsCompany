package com.example.admin.mvpdagger.di;

import com.example.admin.mvpdagger.di.scopes.Activity;
import com.example.admin.mvpdagger.view.mainactivity.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@Activity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void Inject(MainActivity mainActivity);
}
