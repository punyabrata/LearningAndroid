package com.learner.learndroid.view.main;

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

import com.learner.learndroid.R;
import com.learner.learndroid.app.LearnDroidApplication;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.view.adapter.RecyclerViewAdapter;

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
     * Item decors.
     */
    RecyclerView.ItemDecoration listItemDecoration;
    RecyclerView.ItemDecoration gridItemDecoration;

    /**
     * Menu items.
     */
    MenuItem gridOnItem;
    MenuItem gridOffItem;

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

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        listItemDecoration = new ListSpacingItemDecoration(spacingInPixels);
        gridItemDecoration = new GridSpacingItemDecoration(2, spacingInPixels);

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        LearnDroidApplication application = (LearnDroidApplication) getApplication();
        itemViewModel.setRepository(application.getRepository());

        initAdapter();
        setViewType(ViewType.LIST);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar_menu, menu);
        gridOnItem = menu.findItem(R.id.menu_grid);
        gridOffItem = menu.findItem(R.id.menu_list);
        showGridOption(true);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_grid:
                setViewType(ViewType.GRID);
                showGridOption(false);
                return true;
            case R.id.menu_list:
                setViewType(ViewType.LIST);
                showGridOption(true);
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
     * Initializes the recycler view adapter.
     */
    private void initAdapter() {
        Log.d(TAG, "Recycler view adapter is being set up.");
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext());
    }

    /**
     * Sets view type.
     * @param type List vs Grid.
     */
    private void setViewType(ViewType type) {
        recyclerViewAdapter.setViewType(type == ViewType.GRID ? RecyclerViewAdapter.GRID_TYPE : RecyclerViewAdapter.LIST_TYPE);
        recyclerView.setAdapter(recyclerViewAdapter);
        RecyclerView.LayoutManager layoutManager;
        if (type == ViewType.GRID) {
            layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(this);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.invalidateItemDecorations();
        recyclerView.removeItemDecoration(type == ViewType.GRID ? listItemDecoration : gridItemDecoration);
        recyclerView.addItemDecoration(type == ViewType.GRID ? gridItemDecoration : listItemDecoration);
    }

    /**
     * Show Grid vs List menu option.
     * @param show If true, show grid option. Show list option otherwise.
     */
    private void showGridOption(boolean show) {
        gridOnItem.setVisible(show);
        gridOffItem.setVisible(!show);
    }
}
