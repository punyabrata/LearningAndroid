package com.learner.learndroid.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.learner.learndroid.entity.trending.Item;

import java.util.List;

import io.reactivex.Flowable;

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
    Flowable<List<Item>> getAllItems();

    /**
     * Gets the item, from the {@link Item} table, by the id.
     * @param id The item id.
     * @return Item.
     */
    @Query("SELECT * FROM item WHERE itemId = :id")
    Flowable<Item> getItem(String id);

    /**
     * Inserts a list of items into the {@link Item} table.
     * @param items
     */
    @Insert
    void insertAll(Item... items);

    /**
     * Deletes all items from the {@link Item} table.
     */
    @Query("DELETE FROM item")
    void deleteAll();
}
