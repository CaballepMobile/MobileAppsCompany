package com.example.admin.mvvmarchitecturecomp.di;

import android.content.Context;

import com.example.admin.mvvmarchitecturecomp.data.remote.RemoteServiceHelper;
import com.example.admin.mvvmarchitecturecomp.data.remote.RepositoryModule.Repository;
import com.example.admin.mvvmarchitecturecomp.data.remote.RepositoryModule.RepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }

    @Provides
    @Singleton
    public RemoteServiceHelper provideRemoteServideHelper(){
        return new RemoteServiceHelper();
    }

    @Provides
    @Singleton
    public Repository provideRepositoryImpl(RemoteServiceHelper remoteServiceHelper){
        return new RepositoryImpl(remoteServiceHelper);
    }
}
