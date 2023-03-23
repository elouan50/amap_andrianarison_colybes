package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CommandeViewModel extends AndroidViewModel {
    private CommandeRepository commandeRepository;
    private LiveData<List<Commande>> userCommandes;

    public CommandeViewModel(Application application) {

        super(application);
        commandeRepository = new CommandeRepository(application);
    }

    LiveData<List<Commande>> getUserCommandes(Personne personne) {
        userCommandes = commandeRepository.getUserCommandes(personne);
        return userCommandes;
    }
    public void insert(Commande commande) {commandeRepository.insert(commande); }
}
