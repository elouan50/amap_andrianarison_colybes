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

    @Query("SELECT * FROM commande")
    LiveData<List<Commande>> getAllCommandes();
}
