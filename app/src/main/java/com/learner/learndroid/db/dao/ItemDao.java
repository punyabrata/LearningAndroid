package com.learner.learndroid.db.dao;

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
    List<Item> getAllItems();

    @Query("SELECT * FROM item WHERE itemId = :id")
    List<Item> getItem(String id);

    @Insert
    void insert(Item item);

    @Insert
    void insertAll(Item... items);

    @Delete
    void delete(Item item);

    @Delete
    void deleteAll(Item... items);
}
