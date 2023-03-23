package com.ecn.amap;

import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PersonneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Personne personne);

    @Query("DELETE FROM personne")
    void deleteAll();
}
