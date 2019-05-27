package com.learner.learndroid.repository;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learner.learndroid.app.Constants;
import com.learner.learndroid.db.dao.ItemDao;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.entity.trending.WalmartTrending;
import com.learner.learndroid.service.WalmartService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Product Repository is responsible for fetching network data and storing the same into
 * data base.
 */

public class ProductRepository {
    /**
     * Tag for debugging.
     */
    private static final String TAG = ProductRepository.class.getSimpleName();

    /**
     * The item DAO.
     */
    private ItemDao itemDao;

    /**
     * The Walmart service.
     */
    private WalmartService walmartService;

    /**
     * A {@link LiveData} of list of items.
     */
    private MutableLiveData<List<Item>> itemListLiveData = new MutableLiveData<>();

    /**
     * A {@link LiveData} of the current item.
     */
    private MutableLiveData<Item> itemLiveData = new MutableLiveData<>();

    /**
     * Constructs the {@link ProductRepository} object
     *
     * @param walmartService an instance {@link WalmartService}
     */
    public ProductRepository(ItemDao itemDao, WalmartService walmartService, Executor executor) {
        this.itemDao = itemDao;
        this.walmartService = walmartService;
    }

    /**
     * Gets all the items.
     *
     * @return List of items.
     */
    public LiveData<List<Item>> getItems() {
        if (itemListLiveData.getValue() == null) {
            fetchTrendingItems();
            fetchData();
        }
        return itemListLiveData;
    }

    /**
     * Gets the item with the specified id.
     *
     * @param id The item id.
     * @return The item.
     */
    public LiveData<Item> getItem(String id) {
        fetchItem(id);
        return itemLiveData;
    }

    /**
     * Fetches the data from the repository.
     */
    private void fetchData() {
        Log.d(TAG, "Fetch Data");
        itemDao.getAllItems()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(i -> itemListLiveData.setValue(i))
                .subscribe();
    }

    /**
     * Fetches the item with the supplied id from the database.
     *
     * @param id The item id.
     */
    private void fetchItem(String id) {
        itemDao.getItem(id)
                .subscribeOn(Schedulers.computation())
                .doOnError(i -> { throw new IllegalStateException("Item does not exists"); })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(i -> itemLiveData.setValue(i))
                .subscribe();
    }





    /**
     * Fetches trending items from the Walmart server.
     * Updates the database if the fetch is successful.
     */
    private void fetchTrendingItems() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("apiKey", Constants.WALMART_API_KEY);
        map.put("format", "json");
        Log.i(TAG, "Fetch Remote data for all items");
        walmartService.getTrends(map)
                .subscribeOn(Schedulers.io())
                .map(WalmartTrending::getItems)
                .doOnNext(i -> {
                    itemDao.deleteAll();
                    itemDao.insertAll(i.toArray(new Item[0]));
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
