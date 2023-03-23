package com.ecn.amap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fruit")
public class Fruit {
    @PrimaryKey(autoGenerate = true)
    private int fruit_id;
    private String description;

    public int getFruit_id() {
        return fruit_id;
    }

    public void setFruit_id(int fruit_id) {
        this.fruit_id = fruit_id;
    }

    public Fruit(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
