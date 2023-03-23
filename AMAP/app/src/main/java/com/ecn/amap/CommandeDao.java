package com.ecn.amap;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommandeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Commande personne);

    @Query("SELECT * FROM commande WHERE personne_id=:personne_id")
    LiveData<List<Commande>> getUserCommandes(int personne_id);
}
