package com.learner.learndroid.service;

import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.entity.trending.WalmartTrending;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Wal-mart service; Provides trending data, and Reviews
 */
public interface WalmartService {

    /**
     * Base common point for Walmart service.
     */
    String TREND_BASE_POINT = "http://api.walmartlabs.com/v1/";

    @GET("trends")
    Call<WalmartTrending> getTrends(@QueryMap Map<String, String> map);

    @GET("items/{itemid}")
    Call<Item> getItem(@Path("itemid") String itemId, @QueryMap Map<String, String> map);
}
