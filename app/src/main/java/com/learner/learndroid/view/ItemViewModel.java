package com.learner.learndroid.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.learner.learndroid.Product;
import com.learner.learndroid.data.APIData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    /**
     * Live data to hold the list of products.
     */
    private MutableLiveData<List<Product>> liveData = new MutableLiveData<>();

    /**
     * Constructor.
     *
     * @param application
     */
    public ItemViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Gets all the products.
     *
     * @return LiveData for the list of products.
     */
    public LiveData<List<Product>> getAllProducts() {
        liveData.setValue(APIData.getProducts());
        return liveData;
    }

}
