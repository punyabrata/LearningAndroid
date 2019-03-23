package com.learner.learndroid.app;

import android.app.Application;

import com.learner.learndroid.db.AppDatabase;
import com.learner.learndroid.db.dao.ItemDao;
import com.learner.learndroid.repository.ProductRepository;
import com.learner.learndroid.service.WalmartService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The application class.
 */
public class LearnDroidApplication extends Application {
    /**
     * The DAO ( = Data Access Object) for the database {@link AppDatabase}.
     */
    private ItemDao itemDao;
    /**
     * The Walmart Service class.
     */
    private WalmartService walmartService;
    /**
     * The executor to run asynchronous task.
     */
    private Executor executor;
    /**
     * The repository.
     */
    private ProductRepository repository;

    /**
     * Gets the repository.
     *
     * @return The product repository.
     */
    public ProductRepository getRepository() {
        if (repository == null) {
            repository = new ProductRepository(getDao(), getWalmartService(), getExecutor());
        }
        return repository;
    }

    /**
     * Gets the DAO.
     *
     * @return The DAO.
     */
    public ItemDao getDao() {
        if (itemDao == null) {
            itemDao = AppDatabase.getInstance(this).itemDao();
        }
        return itemDao;
    }

    /**
     * Gets the Walmart Service.
     *
     * @return The Walmart Service.
     */
    public WalmartService getWalmartService() {
        if (walmartService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(WalmartService.TREND_BASE_POINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            walmartService = retrofit.create(WalmartService.class);
        }
        return walmartService;
    }

    /**
     * The executor.
     *
     * @return The executor.
     */
    public Executor getExecutor() {
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }
        return executor;
    }
}
