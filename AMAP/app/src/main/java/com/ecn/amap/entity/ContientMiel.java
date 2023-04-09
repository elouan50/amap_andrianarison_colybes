package com.ecn.amap.entity;

import androidx.room.Entity;

@Entity(tableName = "contient_miel", primaryKeys = {"commande_id", "miel_id"})
public class ContientMiel {
    private int commande_id;
    private int miel_id;
    private int quantite;

    public ContientMiel(int commande_id, int miel_id, int quantite){
        this.commande_id = commande_id;
        this.miel_id = miel_id;
        this.quantite = quantite;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public void setMiel_id(int miel_id) {
        this.miel_id = miel_id;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public int getMiel_id() {
        return miel_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
