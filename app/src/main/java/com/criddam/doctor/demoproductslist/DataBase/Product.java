package com.criddam.doctor.demoproductslist.DataBase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "table_product")
public class Product {

    public Product(String productUuid, String shortName, String price, String imageSrc, String printOrder) {
        this.productUuid = productUuid;
        this.shortName = shortName;
        this.price = price;
        this.imageSrc = imageSrc;
        this.printOrder = printOrder;
    }

/*    @PrimaryKey (autoGenerate = true)
    private int id;*/
    @NotNull
    @PrimaryKey
    private final String productUuid;

    private String shortName;
    private String price;
    private String imageSrc;
    private String printOrder;

    public String getProductUuid() {
        return productUuid;
    }

    public String getShortName() {
        return shortName;
    }

    public String getPrice() {
        return price;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getPrintOrder() {
        return printOrder;
    }
}
