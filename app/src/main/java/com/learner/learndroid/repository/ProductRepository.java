package com.learner.learndroid.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.learner.learndroid.app.Constants;
import com.learner.learndroid.db.dao.ItemDao;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.entity.trending.WalmartTrending;
import com.learner.learndroid.service.WalmartService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
     * The executor to run async operation.
     */
    private Executor executor;

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
        this.executor = executor;
    }

    /**
     * Gets all the items.
     *
     * @return List of items.
     */
    public LiveData<List<Item>> getItems() {
        if (itemListLiveData.getValue() == null) {
            refreshItems();
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
        refreshItems();
        fetchItem(id);
        return itemLiveData;
    }

    /**
     * Fetches the data from the repository.
     */
    private void fetchData() {
        Log.d(TAG, "Fetch Data");
        itemDao.getAllItems().observeForever(new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                itemListLiveData.setValue(items);
            }
        });
    }

    /**
     * Fetches the item with the supplied id from the database.
     *
     * @param id The item id.
     */
    private void fetchItem(String id) {
        Log.d(TAG, "Fetch Item");
        itemDao.getItem(id).observeForever(new Observer<Item>() {
            @Override
            public void onChanged(@Nullable Item item) {
                itemLiveData.setValue(item);
            }
        });
    }

    /**
     * Checks if the database has got items.
     * If not, calls the {@link #fetchTrendingItems()} method.
     */
    private void refreshItems() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Item item = itemDao.getAnyItem();
                if (item == null) {
                    Log.v(ProductRepository.class.getSimpleName(), "Refresh Thread: " + Thread.currentThread().getName());
                    fetchTrendingItems();
                }
            }
        });
    }

    /**
     * Fetches trending items from the Walmart server.
     * Updates the database if the fetch is successful.
     */
    private void fetchTrendingItems() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("apiKey", Constants.WALMART_API_KEY);
        map.put("format", "json");


        walmartService.getTrends(map).enqueue(new Callback<WalmartTrending>() {
            @Override
            public void onResponse(@NonNull Call<WalmartTrending> call, @NonNull Response<WalmartTrending> response) {
                Log.v(ProductRepository.class.getSimpleName(), "Success");
                Log.v(ProductRepository.class.getSimpleName(), "Fetch Thread: " + Thread.currentThread().getName());
                WalmartTrending trending = response.body();
                if (trending != null) {
                    new InsertItemAsyncTask(itemDao).execute(trending.getItems().toArray(new Item[0]));
                }
            }

            @Override
            public void onFailure(@NonNull Call<WalmartTrending> call, @NonNull Throwable t) {
                Log.v(ProductRepository.class.getSimpleName(), "Network operation failed");
            }
        });
    }

    /**
     * Async task to insert items to the database.
     */
    private static class InsertItemAsyncTask extends AsyncTask<Item, Void, Void> {

        private ItemDao itemDao;

        private InsertItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.insertAll(items);
            return null;
        }
    }

}
