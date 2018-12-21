package com.learner.learndroid.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.repository.ProductRepository;

import java.util.List;

/**
 * Class item view model.
 */
public class ItemViewModel extends AndroidViewModel {
    /**
     * Live data to hold the list of products.
     */
    private MutableLiveData<List<Item>> liveData = new MutableLiveData<>();

    /**
     * An instance of product repository.
     */
    private ProductRepository repository = null;

    /**
     * Constructor.
     *
     * @param application app
     */
    public ItemViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Sets product repository to the view model .
     * @param productRepository {@link ProductRepository}
     */
    public void setRepository(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    /**
     * Gets all the products.
     *
     * @return LiveData for the list of products.
     */
    public LiveData<List<Item>> getAllProducts() {
        if(liveData.getValue() == null) {
            fetchData();
        }
        return liveData;
    }

    /**
     * Fetches the data from
     */
    private void fetchData() {
        Log.d(ItemViewModel.class.getSimpleName(), "Fetch Data");
        repository.getTrendingItems().observeForever(new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                liveData.setValue(items);
            }
        });
    }

}
