package com.ecn.amap;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContientPainDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ContientPain contientPain);

    @Query("SELECT * FROM contient_pain")
    LiveData<List<ContientPain>> getAllContientPain();

}
