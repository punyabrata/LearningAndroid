package com.learner.learndroid.view;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.repository.ProductRepository;

public class DetailViewModel extends AndroidViewModel {

    /**
     * Tag for debugging.
     */
    private static final String TAG = "DetailViewModel";

    /**
     * Live data to hold the product.
     */
    private MutableLiveData<Item> liveData = new MutableLiveData<>();

    /**
     * An instance of product repository.
     */
    private ProductRepository repository = null;

    /**
     * Constructor.
     *
     * @param application Application instance.
     */
    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Sets product repository to the view model .
     *
     * @param productRepository {@link ProductRepository}
     */
    public void setRepository(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    /**
     * Gets the products using the {@link DetailViewModel#fetchItem(String)} private method.
     *
     * @return LiveData of an item.
     */
    public LiveData<Item> getItem(String itemId) {
        if (liveData.getValue() == null) {
            fetchItem(itemId);
        }
        return liveData;
    }

    /**
     * Fetches the data from the repository.
     */
    private void fetchItem(String id) {
        Log.d(TAG, "Fetch Data");
        repository.getItem(id).observeForever(new Observer<Item>() {
            @Override
            public void onChanged(@Nullable Item item) {
                liveData.setValue(item);
            }
        });
    }
}
