package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class ContientPainRepository {
    private ContientPainDao contientPainDao;
    private LiveData<List<ContientPain>> allContientPain;

    ContientPainRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        contientPainDao = db.contientPainDao();
        allContientPain = contientPainDao.getAllContientPain();
    }

    void insert(ContientPain contientPain) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            contientPainDao.insert(contientPain);
        });
    }

    LiveData<List<ContientPain>> getAllContientPain() {
        return allContientPain;
    }
}
