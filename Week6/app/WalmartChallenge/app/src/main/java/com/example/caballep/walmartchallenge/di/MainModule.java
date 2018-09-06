package com.example.caballep.walmartchallenge.di;

import android.content.Context;

import com.example.caballep.walmartchallenge.data.repository.Repository;
import com.example.caballep.walmartchallenge.data.repository.RepositoryImpl;
import com.example.caballep.walmartchallenge.data.service.RemoteServiceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule
{
    private Context myContext;

    public MainModule(Context myContext)
    {
        this.myContext = myContext;
    }

    @Provides
    @Singleton
    public Context getMyContext()
    {
        return myContext;
    }

    @Provides
    @Singleton
    public RemoteServiceHelper getRemoteServiceHelper()
    {
        return new RemoteServiceHelper();
    }

    @Provides
    @Singleton
    public Repository getRepositoryImpl(RemoteServiceHelper inRmtSrvcHlpr)
    {
        return new RepositoryImpl(inRmtSrvcHlpr);
    }
}
