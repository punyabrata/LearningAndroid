package com.learner.learndroid.entity.trending;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WalmartTrending {

    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
