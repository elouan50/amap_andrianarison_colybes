package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class ContientFruitRepository {
    private ContientFruitDao contientFruitDao;
    private LiveData<List<ContientFruit>> commandeContientFruit;

    ContientFruitRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        contientFruitDao = db.contientFruitDao();
    }

    void insert(ContientFruit contientFruit) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            contientFruitDao.insert(contientFruit);
        });
    }


    LiveData<List<ContientFruit>> getCommandeContientFruit(Commande commande) {
        commandeContientFruit = contientFruitDao.getCommandeContientFruit(commande.getCommmande_id());
        return commandeContientFruit;
    }
}
