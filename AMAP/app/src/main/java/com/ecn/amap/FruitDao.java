package com.ecn.amap;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface FruitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Fruit fruit);
}
