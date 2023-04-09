package com.ecn.amap.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.ecn.amap.entity.Fruit;

@Dao
public interface FruitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Fruit fruit);
}
