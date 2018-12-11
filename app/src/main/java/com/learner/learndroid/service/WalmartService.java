package com.learner.learndroid.service;

import com.learner.learndroid.entity.trending.WalmartTrending;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Wal-mart service; Provides trending data, and Reviews
 */
public interface WalmartService {

    /**
     * Base common point for Walmart service.
     */
    String TREND_BASE_POINT = "http://api.walmartlabs.com/v1/";

    @GET("trends?apiKey={apiKey}&format=json")
    Call<WalmartTrending> getTrends(@Path("apiKey") String apiKey);
}
