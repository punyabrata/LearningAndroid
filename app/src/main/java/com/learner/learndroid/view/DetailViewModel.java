package com.learner.learndroid.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.learner.learndroid.entity.trending.Item;

public class DetailViewModel extends AndroidViewModel {

    /**
     * Live data to hold the product.
     */
    private MutableLiveData<Item> liveData = new MutableLiveData<>();

    /**
     * Constructor.
     *
     * @param application Application instance.
     */
    public DetailViewModel(@NonNull Application application) {
        super(application);
    }


}
