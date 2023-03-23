package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class CommandeRepository {

    private CommandeDao commandeDao;
    private LiveData<List<Commande>> allCommandes;

    CommandeRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        commandeDao = db.commandDao();
    }

    void insert(Commande commande) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            commandeDao.insert(commande);
        });
    }

    LiveData<List<Commande>> getAllCommandes() {
        return allCommandes;
    }
}