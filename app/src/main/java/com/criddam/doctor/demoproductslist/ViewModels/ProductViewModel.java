package com.criddam.doctor.demoproductslist.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.criddam.doctor.demoproductslist.Models.DataModels.ProductDataModel;
import com.criddam.doctor.demoproductslist.Models.Repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = ProductRepository.getInstance(application);
    }

    public MutableLiveData<List<ProductDataModel>> getProductList(){
        return productRepository.getProductsLiveData();
    }


}
