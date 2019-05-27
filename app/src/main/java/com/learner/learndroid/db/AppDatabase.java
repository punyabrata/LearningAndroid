package com.learner.learndroid.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.learner.learndroid.db.dao.ItemDao;
import com.learner.learndroid.entity.trending.Item;

/**
 * App database. Stores the Walmart product information.
 */
@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    /**
     * The database instance.
     */
    private static AppDatabase instance;

    /**
     * Gets the DAO ( = Data Access Object).
     * @return {@link ItemDao} instance
     */
    public abstract ItemDao itemDao();

    /**
     * Gets the database instance.
     * @param context Context.
     * @return The database instance.
     */
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
