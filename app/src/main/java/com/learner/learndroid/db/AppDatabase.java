package com.learner.learndroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.learner.learndroid.db.dao.ItemDao;
import com.learner.learndroid.entity.trending.Item;

/**
 * App data base. Stores the Walmart product information.
 */
@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    /**
     * Return dao object
     * @return {@link ItemDao} instance
     */
    public abstract ItemDao itemDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "app_database").
                    fallbackToDestructiveMigration().
                    build();
        }
        return instance;
    }

}
