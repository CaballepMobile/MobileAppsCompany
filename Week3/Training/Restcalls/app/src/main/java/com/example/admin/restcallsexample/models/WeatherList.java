package com.example.admin.restcallsexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class WeatherList {
    private Integer DT;
    private Main main;
    private List<Weather> weatherList;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Sys sys;
    @SerializedName("dt_txt")
    private String dtText;

    public WeatherList(Integer DT, Main main, List<Weather> weatherList, Clouds clouds, Wind wind, Rain rain, Sys sys, String dtText) {
        this.DT = DT;
        this.main = main;
        this.weatherList = weatherList;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dtText = dtText;
    }

    public Integer getDT() {
        return DT;
    }

    public void setDT(Integer DT) {
        this.DT = DT;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtText() {
        return dtText;
    }

    public void setDtText(String dtText) {
        this.dtText = dtText;
    }
}
