package com.learner.learndroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.learner.learndroid.db.dao.ItemDao;
import com.learner.learndroid.entity.trending.Item;

/**
 * App data base. Stores the Walmart product information.
 */
@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    /**
     * Return dao object
     * @return {@link ItemDao} instance
     */
    public abstract ItemDao itemDao();
}
