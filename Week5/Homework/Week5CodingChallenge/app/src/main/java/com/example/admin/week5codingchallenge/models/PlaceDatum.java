package com.example.admin.week5codingchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceDatum {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("location_type")
    @Expose
    private String locationType;
    @SerializedName("woeid")
    @Expose
    private Integer woeid;
    @SerializedName("latt_long")
    @Expose
    private String lattLong;

    /**
     * No args constructor for use in serialization
     *
     */
    public PlaceDatum() {
    }

    /**
     *
     * @param title
     * @param woeid
     * @param locationType
     * @param lattLong
     */
    public PlaceDatum(String title, String locationType, Integer woeid, String lattLong) {
        super();
        this.title = title;
        this.locationType = locationType;
        this.woeid = woeid;
        this.lattLong = lattLong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Integer getWoeid() {
        return woeid;
    }

    public void setWoeid(Integer woeid) {
        this.woeid = woeid;
    }

    public String getLattLong() {
        return lattLong;
    }

    public void setLattLong(String lattLong) {
        this.lattLong = lattLong;
    }

}