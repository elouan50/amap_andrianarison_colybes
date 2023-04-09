package com.ecn.amap.repository;

import android.app.Application;

import com.ecn.amap.AmapRoomDatabase;
import com.ecn.amap.dao.FruitDao;
import com.ecn.amap.entity.Fruit;

class FruitRepository {
    private FruitDao fruitDao;

    FruitRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        fruitDao = db.fruitDao();
    }

    void insert(Fruit fruit) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            fruitDao.insert(fruit);
        });
    }
}
