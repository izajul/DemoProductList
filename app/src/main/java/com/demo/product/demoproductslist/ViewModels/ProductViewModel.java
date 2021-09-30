package com.demo.product.demoproductslist.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.demo.product.demoproductslist.DataBase.Product;
import com.demo.product.demoproductslist.Models.DataModels.CompactProduct;
import com.demo.product.demoproductslist.Models.DataModels.ProductDataModel;
import com.demo.product.demoproductslist.Models.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository;

    public MutableLiveData<List<CompactProduct>> mCompactProductLiveData  = new MutableLiveData<>();

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = ProductRepository.getInstance(application);
    }

    public LiveData<List<ProductDataModel>> getProductList(){
        return productRepository.getProductsLiveData();
    }

    public LiveData<List<Product>> productsFromDB(){
        return productRepository.getDBProductsLiveData();
    }

    public void insertToDB(ProductDataModel dataModel){
        String url = dataModel.getProductUuid()+"/file/";
        if (dataModel.getFiles()!=null){
            url = url+dataModel.getFiles().get(0).getFileUuid();
        }
        productRepository.insert(new Product(
                dataModel.getProductUuid(),
                dataModel.getShortName(),
                dataModel.getPrice().toString(),
                url,
                dataModel.getProperties().getPrintOrder()  ));
    }

    public void deleteFromDB(Product product){
        productRepository.deleteDBProduct(product);
    }

    public void doCompactWithDBData(List<ProductDataModel> modelList, List<Product> list){

        Executors.newSingleThreadExecutor().execute(()->{
            List<CompactProduct> ls = new ArrayList<>();
            for (ProductDataModel item : modelList) {
                Product product = null;
                for (Product p: list){
                    if (p.getProductUuid().equalsIgnoreCase(item.getProductUuid())){
                        product = p;
                        break;
                    }
                }

                ls.add(new CompactProduct(item,product));
            }

            mCompactProductLiveData.postValue(ls);
        });
    }

    public void doFavoriteAction(CompactProduct product){
        if (product.getDbProduct()==null){
            insertToDB(product.getProductDataModel());
        }else{
            deleteFromDB(product.getDbProduct());
        }
    }

}
