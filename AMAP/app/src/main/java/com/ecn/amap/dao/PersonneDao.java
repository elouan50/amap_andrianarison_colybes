package com.ecn.amap.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ecn.amap.entity.Personne;

@Dao
public interface PersonneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Personne personne);

    @Query("DELETE FROM personne")
    void deleteAll();
}
