package com.ecn.amap.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ecn.amap.entity.Commande;
import com.ecn.amap.entity.Personne;
import com.ecn.amap.repository.CommandeRepository;

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

    public LiveData<Integer> getCommandeId() {
        return commandeRepository.getCommandeId();
    }
}
