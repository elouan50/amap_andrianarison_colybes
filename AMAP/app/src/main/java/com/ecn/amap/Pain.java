package com.ecn.amap;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pain")
public class Pain {
    @PrimaryKey(autoGenerate = true)
    private int pain_id;
    private String desription;

    public Pain(String desription){
        this.desription = desription;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}
