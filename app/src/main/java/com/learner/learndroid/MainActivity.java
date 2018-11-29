package com.learner.learndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**
     * Tag for debugging.
     */
    private static final String TAG = "MainActivity";

    /**
     * List of product names.
     */
    private ArrayList<String> productNames = new ArrayList<>();
    /**
     * List of product image URLs.
     */
    private ArrayList<String> productImageURLs = new ArrayList<>();
    /**
     * List of product descriptions.
     */
    private ArrayList<String> productDescriptions = new ArrayList<>();
    /**
     * List of product original prices.
     */
    private ArrayList<String> productOriginalPrices = new ArrayList<>();
    /**
     * List of product deal prices.
     */
    private ArrayList<String> productDealPrices = new ArrayList<>();
    /**
     * List of product you save texts.
     */
    private ArrayList<String> productYouSaveTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity on create");
        initRecyclerViewItems();
        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "Recycler view is being set up.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(productNames, productImageURLs,
                productDescriptions, productOriginalPrices, productDealPrices, productYouSaveTexts, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initRecyclerViewItems() {
        productImageURLs.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        productNames.add("Apple Macbook Pro");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        productNames.add("Dell Laptop 16 Inch");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        productNames.add("Asus Laptop");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/j6myfqglup501.jpg");
        productNames.add("Apple Macbook Super");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        productNames.add("Lenovo Laptop 14 Inch");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/k98uzl68eh501.jpg");
        productNames.add("IBM Thinkpad");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/glin0nwndo501.jpg");
        productNames.add("Google Chromebook");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.redd.it/obx4zydshg601.jpg");
        productNames.add("Sony Vio");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");

        productImageURLs.add("https://i.imgur.com/ZcLLrkY.jpg");
        productNames.add("Apple Macbook Air");
        productDescriptions.add("Very cool laptop to use");
        productOriginalPrices.add("$1000 USD");
        productDealPrices.add("$500 USD");
        productYouSaveTexts.add("You save $500!");
    }
}
