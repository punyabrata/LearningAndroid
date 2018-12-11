package com.learner.learndroid.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.learner.learndroid.Product;
import com.learner.learndroid.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * Tag for debugging.
     */
    private static final String TAG = "MainActivity";

    /**
     * View model object.
     */
    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity on create");


        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        itemViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                updateRecyclerView(products);
            }
        });


        //This code has to be uncommented once DB is fully implemented.
        //AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        //AppDatabase.class, "database-name").build();
        fetchData();
    }

    private void fetchData() {

    }

    private void updateRecyclerView(List<Product> products) {
        Log.d(TAG, "Recycler view is being set up.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(products,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
