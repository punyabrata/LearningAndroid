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

public class LearnDroidApplication extends Application {

    private ItemDao itemDao;

    private WalmartService walmartService;

    private Executor executor;

    private ProductRepository repository;

    public ProductRepository getRepository() {
        if (repository == null) {
            repository = new ProductRepository(getDao(), getWalmartService(), getExecutor());
        }
        return repository;
    }

    public ItemDao getDao() {
        if (itemDao == null) {
            itemDao = AppDatabase.getInstance(this).itemDao();
        }
        return itemDao;
    }

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

    public Executor getExecutor() {
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }
        return executor;
    }
}
