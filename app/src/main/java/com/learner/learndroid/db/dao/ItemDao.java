package com.learner.learndroid.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.learner.learndroid.entity.trending.Item;

import java.util.List;

/**
 * Item data access object to retrieve data.
 */
@Dao
public interface ItemDao {

    /**
     * Gets all the items from the {@link Item} table.
     * @return
     */
    @Query("SELECT * FROM item")
    LiveData<List<Item>> getAllItems();

    /**
     * Gets the item, from the {@link Item} table, by the id.
     * @param id The item id.
     * @return Item.
     */
    @Query("SELECT * FROM item WHERE itemId = :id")
    LiveData<Item> getItem(String id);

    /**
     * Inserts an item into the {@link Item} table.
     * @param item The item.
     */
    @Insert
    void insert(Item item);

    /**
     * Inserts a list of items into the {@link Item} table.
     * @param items
     */
    @Insert
    void insertAll(Item... items);

    /**
     * Deletes the specified item from the {@link Item} table.
     * @param item The item to delete.
     */
    @Delete
    void delete(Item item);

    /**
     * Deletes a list of items from the {@link Item} table.
     * @param item List of items.
     */
    @Delete
    void deleteAll(Item... item);

    /**
     * Deletes all items from the {@link Item} table.
     */
    @Query("DELETE FROM item")
    void deleteAll();

    /**
     * Gets any item from the {@link Item} table.
     * @return An item.
     */
    @Query("SELECT * FROM item LIMIT 1")
    Item getAnyItem();
}
