package com.learner.learndroid.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.learner.learndroid.R;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.repository.ProductRepository;
import com.learner.learndroid.service.WalmartService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
     * Activity on-create method.
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WalmartService.TREND_BASE_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WalmartService service = retrofit.create(WalmartService.class);
        ProductRepository productRepository = new ProductRepository(service);
        itemViewModel.setRepository(productRepository);
    }

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
     * Updates the recycler view.
     */
    private void initRecyclerView() {
        Log.d(TAG, "Recycler view is being set up.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
