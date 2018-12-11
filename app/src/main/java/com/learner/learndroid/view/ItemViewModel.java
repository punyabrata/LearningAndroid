package com.learner.learndroid.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.learner.learndroid.Product;

import java.util.ArrayList;
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
        liveData.setValue(getProducts());
        return liveData;
    }

    /**
     * Dummy method to get the products.
     * TODO: This will have to be replaced with the data coming from Repository.
     *
     * @return List of products.
     */
    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product("Apple Macbook Pro",
                "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p1);

        Product p2 = new Product("Dell Laptop 16 Inch",
                "https://i.redd.it/tpsnoz5bzo501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p2);

        Product p3 = new Product("Asus Laptop",
                "https://i.redd.it/qn7f9oqu7o501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p3);

        Product p4 = new Product("Apple Macbook Super",
                "https://i.redd.it/j6myfqglup501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p4);

        Product p5 = new Product("Lenovo Laptop 14 Inch",
                "https://i.redd.it/0h2gm1ix6p501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p5);

        Product p6 = new Product("IBM Thinkpad",
                "https://i.redd.it/k98uzl68eh501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p6);

        Product p7 = new Product("Google Chromebook",
                "https://i.redd.it/glin0nwndo501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p7);

        Product p8 = new Product("Sony Vio",
                "https://i.redd.it/obx4zydshg601.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p8);

        Product p9 = new Product("Apple Macbook Air",
                "https://i.imgur.com/ZcLLrkY.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p9);

        return products;
    }

}
