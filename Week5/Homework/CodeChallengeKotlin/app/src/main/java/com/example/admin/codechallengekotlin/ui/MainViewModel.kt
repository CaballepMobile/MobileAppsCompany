package com.example.admin.codechallengekotlin.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.support.design.widget.NavigationView
import android.view.MenuItem
import com.example.admin.codechallengekotlin.AppController
import com.example.admin.codechallengekotlin.R
import com.example.admin.codechallengekotlin.data.repository.Repository
import com.example.admin.codechallengekotlin.utils.SingleEventLiveData
import javax.inject.Inject

class MainViewModel(val context: Application) : AndroidViewModel(context), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var singleEventLiveData: SingleEventLiveData<Boolean>

    init {
        (context as AppController).getComponent().inject(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}