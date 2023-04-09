package com.ecn.amap.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ecn.amap.entity.Commande;
import com.ecn.amap.entity.ContientFruit;
import com.ecn.amap.repository.ContientFruitRepository;

import java.util.List;

public class ContientFruitViewModel extends AndroidViewModel {
    private ContientFruitRepository contientFruitRepository;
    private LiveData<List<ContientFruit>> commandeContientFruit;

    public ContientFruitViewModel(Application application) {

        super(application);

        contientFruitRepository = new ContientFruitRepository(application);
    }

    LiveData<List<ContientFruit>> getCommandeContientFruit(Commande commande) {
        this.commandeContientFruit = contientFruitRepository.getCommandeContientFruit(commande);
        return commandeContientFruit;
    }

    public void insert(ContientFruit contientFruit) {
        contientFruitRepository.insert(contientFruit); }
}
