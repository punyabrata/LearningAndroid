package com.learner.learndroid.view;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Log;

import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.repository.ProductRepository;

import java.util.List;

/**
 * Class item view model.
 */
public class ItemViewModel extends AndroidViewModel {
    /**
     * Tag for debugging.
     */
    private static final String TAG = "ItemViewModel";
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
     * @param application The application instance.
     */
    public ItemViewModel(@NonNull Application application) {
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
     * Gets the products using the {@link ItemViewModel#fetchData()} private method.
     *
     * @return LiveData of list of items.
     */
    public LiveData<List<Item>> getAllProducts() {
        if (liveData.getValue() == null) {
            fetchData();
        }
        return liveData;
    }

    /**
     * Fetches the data from the repository.
     */
    private void fetchData() {
        Log.d(TAG, "Fetch Data");
        repository.getItems().observeForever(new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                liveData.setValue(items);
            }
        });
    }
}
