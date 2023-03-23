package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class CommandeRepository {

    private CommandeDao commandeDao;
    private LiveData<List<Commande>> userCommandes;

    CommandeRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        commandeDao = db.commandDao();
    }

    void insert(Commande commande) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            commandeDao.insert(commande);
        });
    }


    LiveData<List<Commande>> getUserCommandes(Personne personne) {
        userCommandes = commandeDao.getUserCommandes(personne.getPersonne_id());
        return userCommandes;
    }
}