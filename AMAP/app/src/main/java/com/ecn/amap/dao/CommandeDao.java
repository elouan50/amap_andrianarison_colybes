package com.ecn.amap.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ecn.amap.entity.Commande;

import java.util.List;

@Dao
public interface CommandeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Commande commande);

    @Query("SELECT * FROM commande WHERE personne_id=:personne_id")
    LiveData<List<Commande>> getUserCommandes(int personne_id);

    @Query("SELECT MAX(commande.commmande_id) FROM commande")
    LiveData<Integer> getCommandeId();
}
