package com.example.admin.codechallengekotlin.ui

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.admin.codechallengekotlin.AppController
import com.example.admin.codechallengekotlin.R
import com.example.admin.codechallengekotlin.databinding.ActivityMainBinding
import com.example.admin.codechallengekotlin.di.activity.ActivityModule
import com.example.admin.codechallengekotlin.ui.MainViewModel
import com.example.admin.codechallengekotlin.utils.Constants

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Glide.with(activityMainBinding.imageView.context).load(Constants.HOME_IMAGE).into(activityMainBinding.imageView)
        injectDependencies()
        setUpObservers()
        setUpListeners()
        activityMainBinding.viewModel = mainViewModel
    }

    private fun injectDependencies() {
        (application as AppController).getComponent().newActivityComponent(ActivityModule(this)).inject(this)
    }

    private fun setUpObservers() {
        mainViewModel.getWeatherForecast().observe(this, Observer {

            activityMainBinding.imageView.apply {
                adapter = it
                layoutManager = LinearLayoutManager(this@MainActivity)
            )
        })

        mainViewModel.singleEventLiveData.observe(this, Observer {
            activityMainBinding.drawerLayout.closeDrawers()
        })
    }

    private fun setUpListeners() {
        activityMainBinding.navView.setNavigationItemSelectedListener(mainViewModel)
    }
}
