package com.ecn.amap;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Personne.class, Commande.class, Fruit.class, ContientFruit.class}, version = 1, exportSchema = false)
public abstract class AmapRoomDatabase extends RoomDatabase {
    public abstract PersonneDao personneDao();
    public abstract CommandeDao commandDao();
    public abstract FruitDao fruitDao();
    public abstract ContientFruitDao contientFruitDao();

    private static volatile AmapRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AmapRoomDatabase getDatabase(final Context context) {
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
