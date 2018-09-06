package com.example.admin.codechallengekotlin.data.remote

import com.example.admin.codechallengekotlin.data.remote.models.MetaWeatherResponse
import com.example.admin.codechallengekotlin.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.LocalDate
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteServiceHelper {
    fun getWeatherForecast(woeid: String): Deferred<List<MetaWeatherResponse>> {
        val retrofit = getRetrofit(Constants.BASE_URL)
        val service = retrofit.create(RemoteService::class.java)
        val localDate = LocalDate().plusDays(1)
        return service.getWeatherForecast(woeid, localDate.toString("YYY/MM/dd"))
    }

    private fun getRetrofit(baseUrl : String): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpClient)
                .build()
    }
}
