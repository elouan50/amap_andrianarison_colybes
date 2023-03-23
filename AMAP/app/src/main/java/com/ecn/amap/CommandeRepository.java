package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class CommandeRepository {

    private CommandeDao commandeDao;
    private LiveData<List<Commande>> userCommandes;
    private int cid;

    CommandeRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        commandeDao = db.commandDao();
    }

    void insert(Commande commande) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            commandeDao.insert(commande);
        });
    }

    LiveData<Integer> getCommandeId() {
        return commandeDao.getCommandeId();
    }

    LiveData<List<Commande>> getUserCommandes(Personne personne) {
        userCommandes = commandeDao.getUserCommandes(personne.getPersonne_id());
        return userCommandes;
    }
}