package com.criddam.doctor.demoproductslist.DataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Product.class, version = 1)
public abstract class ProductDB extends RoomDatabase {

    private static ProductDB instance;

    public abstract ProductDAO productDAO();

    public static final ExecutorService dbExecutor =
            Executors.newFixedThreadPool(4);

    public static synchronized ProductDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ProductDB.class,"product_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

}
