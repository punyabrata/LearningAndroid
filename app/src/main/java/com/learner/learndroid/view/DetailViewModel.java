package com.learner.learndroid.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.learner.learndroid.Product;
import com.learner.learndroid.data.APIData;

public class DetailViewModel extends AndroidViewModel {

    /**
     * Live data to hold the product.
     */
    private MutableLiveData<Product> liveData = new MutableLiveData<>();

    /**
     * Constructor.
     *
     * @param application Application instance.
     */
    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Gets the product by id.
     *
     * @param id Product id.
     * @return Live data object holding the product object.
     */
    public LiveData<Product> getProductById(String id) {
        liveData.setValue(APIData.getProductById(id));
        return liveData;
    }
}
