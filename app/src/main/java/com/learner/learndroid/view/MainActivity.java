package com.learner.learndroid.view;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.learner.learndroid.R;
import com.learner.learndroid.app.LearnDroidApplication;
import com.learner.learndroid.entity.trending.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
     * Recycler view.
     */
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    /**
     * Action bar.
     */
    @BindView(R.id.main_toolbar)
    Toolbar actionBar;

    /**
     * The {@link Activity#onCreate(Bundle)} method.
     *
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d(TAG, "Main Activity on create.");

        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle(R.string.main_activity_title);

        initRecyclerView();
        setListType();

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        LearnDroidApplication application = (LearnDroidApplication) getApplication();
        itemViewModel.setRepository(application.getRepository());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_grid:
                setGridType();
                return true;
            case R.id.menu_list:
                setListType();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext());
    }

    private void setListType() {
        recyclerViewAdapter.setViewType(RecyclerViewAdapter.LIST_TYPE);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setGridType() {
        recyclerViewAdapter.setViewType(RecyclerViewAdapter.GRID_TYPE);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }
}
