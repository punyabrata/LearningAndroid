package com.learner.learndroid.entity.reviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OverallRating {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("rating")
    @Expose
    private String rating;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
