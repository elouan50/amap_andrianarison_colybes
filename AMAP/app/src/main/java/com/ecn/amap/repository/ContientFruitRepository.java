package com.ecn.amap.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ecn.amap.AmapRoomDatabase;
import com.ecn.amap.entity.Commande;
import com.ecn.amap.dao.ContientFruitDao;
import com.ecn.amap.entity.ContientFruit;

import java.util.List;

public class ContientFruitRepository {
    private ContientFruitDao contientFruitDao;
    private LiveData<List<ContientFruit>> commandeContientFruit;

    public ContientFruitRepository(Application application) {
        AmapRoomDatabase db = AmapRoomDatabase.getDatabase(application);
        contientFruitDao = db.contientFruitDao();
    }

    public void insert(ContientFruit contientFruit) {
        AmapRoomDatabase.databaseWriteExecutor.execute(() -> {
            contientFruitDao.insert(contientFruit);
        });
    }


    public LiveData<List<ContientFruit>> getCommandeContientFruit(Commande commande) {
        commandeContientFruit = contientFruitDao.getCommandeContientFruit(commande.getCommmande_id());
        return commandeContientFruit;
    }
}
