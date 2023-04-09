package com.ecn.amap.repository;

import android.app.Application;

import com.ecn.amap.AmapRoomDatabase;
import com.ecn.amap.dao.PersonneDao;
import com.ecn.amap.entity.Personne;

class PersonneRepository {

    private PersonneDao personneDao;

    PersonneRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        personneDao = db.personneDao();
    }

    void insert(Personne personne) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            personneDao.insert(personne);
        });
    }
}