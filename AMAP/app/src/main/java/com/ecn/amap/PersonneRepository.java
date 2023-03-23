package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

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