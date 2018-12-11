package com.learner.learndroid.entity.reviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("overallRating")
    @Expose
    private OverallRating overallRating;
    @SerializedName("reviewer")
    @Expose
    private String reviewer;
    @SerializedName("reviewText")
    @Expose
    private String reviewText;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("upVotes")
    @Expose
    private String upVotes;
    @SerializedName("downVotes")
    @Expose
    private String downVotes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OverallRating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(OverallRating overallRating) {
        this.overallRating = overallRating;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(String upVotes) {
        this.upVotes = upVotes;
    }

    public String getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(String downVotes) {
        this.downVotes = downVotes;
    }

}
