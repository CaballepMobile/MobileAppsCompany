package com.example.admin.codingchallengetry2.models.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("crawl_rate")
    @Expose
    private Integer crawlRate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Source() {
    }

    /**
     *
     * @param title
     * @param crawlRate
     * @param slug
     * @param url
     */
    public Source(String title, String slug, String url, Integer crawlRate) {
        super();
        this.title = title;
        this.slug = slug;
        this.url = url;
        this.crawlRate = crawlRate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCrawlRate() {
        return crawlRate;
    }

    public void setCrawlRate(Integer crawlRate) {
        this.crawlRate = crawlRate;
    }

}
