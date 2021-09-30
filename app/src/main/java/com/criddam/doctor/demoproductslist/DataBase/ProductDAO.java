package com.criddam.doctor.demoproductslist.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    void insert(Product product);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Product product);

    @Delete
    void deleteProduct(Product product);

    @Query("DELETE from table_product")
    void deleteAllProduct();

    @Query("SELECT * FROM table_product WHERE productUuid = :uuId")
    LiveData<Product> getProductByUuId(String uuId);

    @Query("SELECT * FROM table_product")
    LiveData<List<Product>> getAllProducts();
}
