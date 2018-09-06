package com.example.admin.codingchallengetry2.di.components;

import com.example.admin.codingchallengetry2.di.modules.WeatherModule;
import com.example.admin.codingchallengetry2.models.entities.PlaceForecastDatum;
import com.example.admin.codingchallengetry2.models.services.PlaceForecastDatumService;

import dagger.Component;

@Component(modules = {WeatherModule.class})
public interface PlaceForecastDatumComponent {
    public PlaceForecastDatumService getPlaceForecastDatumService();
}
