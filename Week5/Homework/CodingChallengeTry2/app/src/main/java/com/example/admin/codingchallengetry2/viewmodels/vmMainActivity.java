package com.example.admin.codingchallengetry2.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.example.admin.codingchallengetry2.di.components.DaggerPlaceForecastDatumComponent;
import com.example.admin.codingchallengetry2.di.modules.RetrofitModule;
import com.example.admin.codingchallengetry2.models.services.PlaceForecastDatumService;
import com.example.admin.codingchallengetry2.utils.Constants;

public class vmMainActivity extends ViewModel {

        private PlaceForecastDatumService placeForecastDatumService;

        vmMainActivity() {
            placeForecastDatumService = DaggerPlaceForecastDatumComponent
                    .builder()
                    //.retrofitModule(RetrofitModule(Constants.WEATHER_BASE_URL))
                    .build()
                    .getPlaceForecastDatumService();
        }


}
