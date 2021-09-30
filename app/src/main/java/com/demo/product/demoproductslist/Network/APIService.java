package com.demo.product.demoproductslist.Network;

import com.demo.product.demoproductslist.Models.DataModels.ProductDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("product?show_hierarchy=true&product_type=ITEM&show_files=true")
    Call<List<ProductDataModel>> getProductList();
}
