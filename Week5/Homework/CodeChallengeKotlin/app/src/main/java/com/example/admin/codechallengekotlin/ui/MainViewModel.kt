package com.example.admin.codechallengekotlin.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.support.design.widget.NavigationView
import android.view.MenuItem
import com.example.admin.codechallengekotlin.AppController
import com.example.admin.codechallengekotlin.R
import com.example.admin.codechallengekotlin.adapters.WeatherAdapter
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
        when(item.title){

            context.getString(R.string.gothenburg) -> makeWeatherForecast("890869")
            context.getString(R.string.london) -> makeWeatherForecast("44418")
            context.getString(R.string.new_york) -> makeWeatherForecast("2459115")
            context.getString(R.string.mountain_view) -> makeWeatherForecast("2455920")
            context.getString(R.string.berlin) -> makeWeatherForecast("638242")
            context.getString(R.string.stockholm) -> makeWeatherForecast("906057")
        }
        item.isChecked = true
        singleEventLiveData.value = true
        return true
    }

    fun getWeatherForecast(): LiveData<WeatherAdapter> {
        return Transformations.map(repository.weatherForecastLiveData) { list -> WeatherAdapter(list, context)}
    }

    private fun makeWeatherForecast(woeId: String) {
        repository.getWeatherForecast(woeId)
    }
}