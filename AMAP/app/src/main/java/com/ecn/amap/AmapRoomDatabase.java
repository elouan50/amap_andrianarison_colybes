package com.ecn.amap;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.ecn.amap.dao.CommandeDao;
import com.ecn.amap.dao.ContientFruitDao;
import com.ecn.amap.dao.FruitDao;
import com.ecn.amap.dao.PersonneDao;
import com.ecn.amap.entity.Commande;
import com.ecn.amap.entity.ContientFruit;
import com.ecn.amap.entity.Fruit;
import com.ecn.amap.entity.Personne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Personne.class, Commande.class, Fruit.class, ContientFruit.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AmapRoomDatabase extends RoomDatabase {
    public abstract PersonneDao personneDao();
    public abstract CommandeDao commandDao();
    public abstract FruitDao fruitDao();
    public abstract ContientFruitDao contientFruitDao();

    private static volatile AmapRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AmapRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AmapRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AmapRoomDatabase.class, "amap_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
