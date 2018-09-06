package com.example.admin.codechallengekotlin.di.activity

import com.example.admin.codechallengekotlin.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}