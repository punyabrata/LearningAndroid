package com.learner.learndroid.entity.reviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewStatistics {

    @SerializedName("averageOverallRating")
    @Expose
    private String averageOverallRating;
    @SerializedName("overallRatingRange")
    @Expose
    private String overallRatingRange;
    @SerializedName("ratingDistributions")
    @Expose
    private List<RatingDistribution> ratingDistributions = null;
    @SerializedName("totalReviewCount")
    @Expose
    private String totalReviewCount;

    public String getAverageOverallRating() {
        return averageOverallRating;
    }

    public void setAverageOverallRating(String averageOverallRating) {
        this.averageOverallRating = averageOverallRating;
    }

    public String getOverallRatingRange() {
        return overallRatingRange;
    }

    public void setOverallRatingRange(String overallRatingRange) {
        this.overallRatingRange = overallRatingRange;
    }

    public List<RatingDistribution> getRatingDistributions() {
        return ratingDistributions;
    }

    public void setRatingDistributions(List<RatingDistribution> ratingDistributions) {
        this.ratingDistributions = ratingDistributions;
    }

    public String getTotalReviewCount() {
        return totalReviewCount;
    }

    public void setTotalReviewCount(String totalReviewCount) {
        this.totalReviewCount = totalReviewCount;
    }

}
