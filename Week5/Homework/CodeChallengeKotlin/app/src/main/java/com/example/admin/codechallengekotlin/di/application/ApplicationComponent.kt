package com.example.admin.codechallengekotlin.di.application

import com.example.admin.codechallengekotlin.di.activity.ActivityComponent
import com.example.admin.codechallengekotlin.di.activity.ActivityModule
import com.example.admin.codechallengekotlin.ui.MainViewModel
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, LiveDataModule::class])
interface ApplicationComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
    fun inject(mainViewModel: MainViewModel)
}