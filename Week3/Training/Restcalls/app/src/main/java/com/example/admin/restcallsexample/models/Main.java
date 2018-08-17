package com.example.admin.restcallsexample.models;

import com.google.gson.annotations.SerializedName;

public class Main {

    private Double temp;
    @SerializedName("temp_min")
    private Double tempMin;
    @SerializedName("temp_max")
    private Double tempMax;
    private Double pressure;
    @SerializedName("sea_level")
    private Double seaLevel;
    @SerializedName("grnd_level")
    private Double grndLevel;
    private Integer humidity;
    @SerializedName("temp_kf")
    private Double tempKf;

    public Main(Double temp, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel, Integer humidity, Double tempKf) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTempKf() {
        return tempKf;
    }

    public void setTempKf(Double tempKf) {
        this.tempKf = tempKf;
    }
}