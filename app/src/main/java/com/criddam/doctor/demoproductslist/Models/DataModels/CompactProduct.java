package com.criddam.doctor.demoproductslist.Models.DataModels;

import androidx.annotation.Nullable;

import com.criddam.doctor.demoproductslist.DataBase.Product;

public class CompactProduct {
    private ProductDataModel productDataModel;
    @Nullable private Product dbProduct;

    public CompactProduct(ProductDataModel productDataModel, @Nullable Product dbProduct) {
        this.productDataModel = productDataModel;
        this.dbProduct = dbProduct;
    }

    public ProductDataModel getProductDataModel() {
        return productDataModel;
    }

    @Nullable
    public Product getDbProduct() {
        return dbProduct;
    }
}
