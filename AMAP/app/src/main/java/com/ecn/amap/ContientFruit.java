package com.ecn.amap;

import androidx.room.Entity;

@Entity(tableName = "contient_fruit", primaryKeys = {"commande_id", "fruit_id"})
public class ContientFruit {
    private int commande_id;
    private int fruit_id;
    private int quantite;

    public ContientFruit(int commande_id, int fruit_id, int quantite){
        this.commande_id = commande_id;
        this.fruit_id = fruit_id;
        this.quantite = quantite;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public int getFruit_id() {
        return fruit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
