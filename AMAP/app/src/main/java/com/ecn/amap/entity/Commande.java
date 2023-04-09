package com.ecn.amap.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "commande")
public class Commande {
    @PrimaryKey(autoGenerate = true)
    private int commmande_id;
    @NonNull private Date date;
    @NonNull private Date livraison;
    private int personne_id;

    public Commande(Date date, Date livraison, int personne_id){
        this.date = date;
        this.livraison = livraison;
        this.personne_id = personne_id;
    }

    public int getCommmande_id() {
        return commmande_id;
    }

    public void setCommmande_id(int commmande_id) {
        this.commmande_id = commmande_id;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public Date getLivraison() {
        return livraison;
    }

    public void setLivraison(@NonNull Date livraison) {
        this.livraison = livraison;
    }

    public int getPersonne_id() {
        return personne_id;
    }

    public void setPersonne_id(int personne_id) {
        this.personne_id = personne_id;
    }
}
