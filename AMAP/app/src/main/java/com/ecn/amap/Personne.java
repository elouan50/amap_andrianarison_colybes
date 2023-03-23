package com.ecn.amap;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "personne")
public class Personne {
    @PrimaryKey(autoGenerate = true)
    private int personne_id;

    @NonNull private String nom;
    @NonNull private String prenom;
    private String telephone;

    public Personne(@NonNull String nom, @NonNull String prenom, String telephone){
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
    }

    public int getPersonne_id() {
        return personne_id;
    }

    @NonNull
    public String getNom() {
        return nom;
    }

    public void setNom(@NonNull String nom) {
        this.nom = nom;
    }

    @NonNull
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(@NonNull String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
