package com.example.admin.codechallengekotlin.di.application

import android.content.Context
import com.example.admin.codechallengekotlin.AppController
import com.example.admin.codechallengekotlin.data.remote.RemoteServiceHelper
import com.example.admin.codechallengekotlin.data.repository.Repository
import com.example.admin.codechallengekotlin.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: AppController) {

    @Provides
    @ApplicationScope
    fun providesApplicationContext(): Context {
        return application
    }

    @Provides
    @ApplicationScope
    fun providesRometeServiceHelper(): RemoteServiceHelper {
        return RemoteServiceHelper()
    }

    @Provides
    @ApplicationScope
    fun provideRepositoryImpl(remoteServiceHelper: RemoteServiceHelper): Repository {
        return RepositoryImpl(remoteServiceHelper)
    }
}