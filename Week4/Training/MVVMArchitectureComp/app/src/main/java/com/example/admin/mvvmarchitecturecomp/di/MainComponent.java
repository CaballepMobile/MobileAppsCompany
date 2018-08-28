package com.example.admin.mvvmarchitecturecomp.di;

import com.example.admin.mvvmarchitecturecomp.ui.MainActivity;
import com.example.admin.mvvmarchitecturecomp.ui.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void Inject(MainActivity mainActivity);
    void Inject(MainViewModel mainViewModel);
}
