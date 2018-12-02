package com.learner.learndroid.entity.trending;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("features")
    @Expose
    private String features;
    @SerializedName("isSortable")
    @Expose
    private String isSortable;
    @SerializedName("mainimageurl")
    @Expose
    private String mainimageurl;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getIsSortable() {
        return isSortable;
    }

    public void setIsSortable(String isSortable) {
        this.isSortable = isSortable;
    }

    public String getMainimageurl() {
        return mainimageurl;
    }

    public void setMainimageurl(String mainimageurl) {
        this.mainimageurl = mainimageurl;
    }
}
