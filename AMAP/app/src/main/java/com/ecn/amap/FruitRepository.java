package com.ecn.amap;

import android.app.Application;

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
