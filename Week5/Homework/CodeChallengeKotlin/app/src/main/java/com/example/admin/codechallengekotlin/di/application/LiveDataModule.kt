package com.example.admin.codechallengekotlin.di.application

import com.example.admin.codechallengekotlin.utils.SingleEventLiveData
import dagger.Module
import dagger.Provides

@Module
class LiveDataModule {
    @Provides
fun providesSingleEventLiveData(): SingleEventLiveData<Boolean> {
        return SingleEventLiveData();
    }
}