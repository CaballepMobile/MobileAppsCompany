package com.example.caballep.walmartchallenge.di;
import com.example.caballep.walmartchallenge.ui.MainActivity;
import com.example.caballep.walmartchallenge.ui.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent
{
    void inject(MainActivity mainActivity);
    void inject(MainViewModel mainViewModel);
}
