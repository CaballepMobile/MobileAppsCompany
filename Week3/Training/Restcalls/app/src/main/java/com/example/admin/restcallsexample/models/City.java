package com.example.admin.restcallsexample.models;

public class City {
    private Integer cityId;
    private String name;
    private Coord coord;
    private String country;
    private Integer population;

    public City(Integer cityId, String name, Coord coord, String country, Integer population) {
        this.cityId = cityId;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
