package com.example.admin.codechallengekotlin.data.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.admin.codechallengekotlin.data.remote.RemoteServiceHelper
import com.example.admin.codechallengekotlin.data.remote.models.MetaWeatherResponse
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.launch
import retrofit2.HttpException

class RepositoryImpl(private val remoteServiceHelper: RemoteServiceHelper) : Repository {

    override val weatherForecastLiveData: MutableLiveData<List<MetaWeatherResponse>> = MutableLiveData()

    override fun getWeatherForecast(woeId: String) {

        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            if (throwable is HttpException) {
                //TODO implement exception handling
                Log.d("Main", "In HttpException")

            } else {
                //TODO implement exception handling
                Log.d("Main", "Other error", throwable.fillInStackTrace())
            }
        }

        launch(exceptionHandler) {
            val metaWeatherResponse = remoteServiceHelper.getWeatherForecast(woeId).await()
            weatherForecastLiveData.postValue(metaWeatherResponse)
        }
    }
}