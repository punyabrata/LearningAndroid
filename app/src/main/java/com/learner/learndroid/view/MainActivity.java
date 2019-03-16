package com.learner.learndroid.view;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.learner.learndroid.R;
import com.learner.learndroid.app.LearnDroidApplication;
import com.learner.learndroid.entity.trending.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * Tag for debugging.
     */
    private static final String TAG = "MainActivity";

    /**
     * Recycler view adapter.
     */
    private RecyclerViewAdapter recyclerViewAdapter;

    /**
     * View model
     */
    private ItemViewModel itemViewModel;

    /**
     * The {@link Activity#onCreate(Bundle)} method.
     *
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Activity on create");
        initRecyclerView();

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        //This code has to be uncommented once DB is fully implemented.
        //AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        //AppDatabase.class, "database-name").build();

        LearnDroidApplication application = (LearnDroidApplication)getApplication();
        itemViewModel.setRepository(application.getRepository());
    }

    /**
     * The {@link Activity#onResume()} method. We fetch all the products/items in this and sets the
     * item data to the recycler view adapter and notify the adapter that the data has changed so
     * that it can reload the data to the view.
     */
    @Override
    protected void onResume() {
        super.onResume();
        itemViewModel.getAllProducts().observe(this,
                new Observer<List<Item>>() {
                    @Override
                    public void onChanged(@Nullable List<Item> items) {
                        recyclerViewAdapter.setItemData(items);
                        recyclerViewAdapter.notifyDataSetChanged();
                    }
                });
    }

    /**
     * Initializes the recycler view.
     */
    private void initRecyclerView() {
        Log.d(TAG, "Recycler view is being set up.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
