package com.ecn.amap;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContientFruitViewModel extends AndroidViewModel {
    private ContientFruitRepository contientFruitRepository;
    private LiveData<List<ContientFruit>> commandeContientFruit;

    public ContientFruitViewModel(Application application) {
        super(application);
    }

    LiveData<List<ContientFruit>> getCommandeContientFruit(Commande commande) {
        this.commandeContientFruit = contientFruitRepository.getCommandeContientFruit(commande);
        return commandeContientFruit;
    }

    public void insert(ContientFruit contientFruit) {
        contientFruitRepository.insert(contientFruit); }
}
