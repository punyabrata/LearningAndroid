package com.learner.learndroid.entity.reviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingDistribution {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("ratingValue")
    @Expose
    private String ratingValue;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

}
