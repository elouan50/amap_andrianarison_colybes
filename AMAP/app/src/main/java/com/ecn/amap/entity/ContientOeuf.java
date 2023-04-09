package com.ecn.amap.entity;

import androidx.room.Entity;

@Entity(tableName = "contient_oeuf", primaryKeys = {"commande_id", "oeuf_id"})
public class ContientOeuf {
    private int commande_id;
    private int oeuf_id;
    private int quantite;

    public ContientOeuf(int commande_id, int oeuf_id, int quantite){
        this.commande_id = commande_id;
        this.oeuf_id = oeuf_id;
        this.quantite = quantite;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public void setOeuf_id(int oeuf_id) {
        this.oeuf_id = oeuf_id;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public int getOeuf_id() {
        return oeuf_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
