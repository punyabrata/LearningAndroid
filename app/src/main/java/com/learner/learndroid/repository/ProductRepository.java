package com.learner.learndroid.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.learner.learndroid.Constants;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.entity.trending.WalmartTrending;
import com.learner.learndroid.service.WalmartService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Product Repository is responsible for fetching network data and storing the same into
 * data base.
 */

public class ProductRepository {

    /**
     * A walmart service
     */
    private WalmartService walmartService;

    /**
     * Constructs the {@link ProductRepository} object
     * @param walmartService an instance {@link WalmartService}
     */
    public ProductRepository(WalmartService walmartService) {
        this.walmartService = walmartService;
    }

    /**
     * Gets trending items from the network.
     * @return an instance of {@link MutableLiveData}
     */
    public LiveData<List<Item>> getTrendingItems() {

        final MutableLiveData<List<Item>> itemMutableLiveData = new MutableLiveData<>();

        Map<String, String> map = new LinkedHashMap<>();
        map.put("apiKey", Constants.WALMART_API_KEY);
        map.put("format", "json");

        walmartService.getTrends(map).enqueue(new Callback<WalmartTrending>() {
            @Override
            public void onResponse(Call<WalmartTrending> call, Response<WalmartTrending> response) {
                Log.v(ProductRepository.class.getSimpleName(), "Success");
                WalmartTrending trending = response.body();
                if(trending != null) {
                    itemMutableLiveData.setValue(trending.getItems());
                }
            }

            @Override
            public void onFailure(Call<WalmartTrending> call, Throwable t) {
                Log.v(ProductRepository.class.getSimpleName(), "Network operation failed");
                itemMutableLiveData.setValue(new ArrayList<Item>());
            }
        });

        return itemMutableLiveData;
    }
}
