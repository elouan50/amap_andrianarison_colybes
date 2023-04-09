package com.ecn.amap.entity;

import androidx.room.Entity;

@Entity(tableName = "contient_legume", primaryKeys = {"commande_id", "legume_id"})
public class ContientLegume {
    private int commande_id;
    private int pain_id;
    private int quantite;

    public ContientLegume(int commande_id, int miel_id, int quantite){
        this.commande_id = commande_id;
        this.pain_id = miel_id;
        this.quantite = quantite;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public void setPain_id(int pain_id) {
        this.pain_id = pain_id;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public int getPain_id() {
        return pain_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
