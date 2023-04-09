package com.ecn.amap.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ecn.amap.AmapRoomDatabase;
import com.ecn.amap.entity.Commande;
import com.ecn.amap.dao.CommandeDao;
import com.ecn.amap.entity.Personne;

import java.util.List;

public class CommandeRepository {

    private CommandeDao commandeDao;
    private LiveData<List<Commande>> userCommandes;
    private int cid;

    public CommandeRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        commandeDao = db.commandDao();
    }

    public void insert(Commande commande) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            commandeDao.insert(commande);
        });
    }

    public LiveData<Integer> getCommandeId() {
        return commandeDao.getCommandeId();
    }

    public LiveData<List<Commande>> getUserCommandes(Personne personne) {
        userCommandes = commandeDao.getUserCommandes(personne.getPersonne_id());
        return userCommandes;
    }
}