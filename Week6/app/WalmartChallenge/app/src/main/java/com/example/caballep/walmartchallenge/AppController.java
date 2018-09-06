package com.example.caballep.walmartchallenge;

import android.app.Application;

import com.example.caballep.walmartchallenge.di.DaggerMainComponent;
import com.example.caballep.walmartchallenge.di.MainComponent;
import com.example.caballep.walmartchallenge.di.MainModule;

public class AppController extends Application
{
    private MainComponent myMainComponet;

    public MainComponent getAppComponet() {
        if (myMainComponet == null)
        {
            myMainComponet = DaggerMainComponent.builder()
                    .mainModule(new MainModule(this))
                    .build();
        }

        return myMainComponet;
    }
}
