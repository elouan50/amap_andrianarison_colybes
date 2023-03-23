package com.ecn.amap;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContientFruitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ContientFruit contientFruit);


    @Query("SELECT * FROM contient_fruit WHERE commande_id=:commande_id")
    LiveData<List<ContientFruit>> getCommandeContientFruit(int commande_id);

}
