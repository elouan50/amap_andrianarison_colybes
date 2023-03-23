package com.ecn.amap;

import android.app.Application;

class PainRepository {
    private PainDao painDao;

    PainRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        painDao = db.painDao();
    }

    void insert(Pain pain) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            painDao.insert(pain);
        });
    }
}
