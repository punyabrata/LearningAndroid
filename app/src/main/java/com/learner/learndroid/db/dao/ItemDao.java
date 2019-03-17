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

    @Query("SELECT * FROM item")
    LiveData<List<Item>> getAllItems();

    @Query("SELECT * FROM item WHERE itemId = :id")
    LiveData<Item> getItem(String id);

    @Insert
    void insert(Item item);

    @Insert
    void insertAll(Item... items);

    @Delete
    void delete(Item item);

    @Delete
    void deleteAll(Item... items);

    @Query("SELECT * FROM item LIMIT 1")
    Item getAnyItem();
}
