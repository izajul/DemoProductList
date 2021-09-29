package com.criddam.doctor.demoproductslist.Models.Repository;

import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.criddam.doctor.demoproductslist.Dagger.Componets.DaggerRetroComponent;
import com.criddam.doctor.demoproductslist.Dagger.Componets.RetroComponent;
import com.criddam.doctor.demoproductslist.Models.DataModels.ProductDataModel;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private static final String TAG = "ProductRepository";

    private static Context mContext;

    private static ProductRepository instance;

    private RetroComponent component;

    private MutableLiveData<List<ProductDataModel>> productsLiveData;

    public ProductRepository() {
        component = DaggerRetroComponent.create();
    }

    public static ProductRepository getInstance(Context context){
        if (instance == null){
            mContext = context;
            instance = new ProductRepository();
        }
        return instance;
    }

    public MutableLiveData<List<ProductDataModel>> getProductsLiveData(){

        if (productsLiveData==null){
            productsLiveData = new MutableLiveData<>();
        }

        component.getApiService().getProductList().enqueue(new Callback<List<ProductDataModel>>() {
            @Override
            public void onResponse(Call<List<ProductDataModel>> call, Response<List<ProductDataModel>> response) {
                Log.d(TAG, "onResponse: "+ new Gson().toJson(response.body()));
                productsLiveData.postValue(response.body());
                switch (response.code()){
                    case 200:  Toast.makeText(mContext,"Requesting Success",Toast.LENGTH_LONG).show();
                        break;
                    case 500: Toast.makeText(mContext,"Internal Server Error",Toast.LENGTH_LONG).show();
                        break;
                    case 404: Toast.makeText(mContext,"Not Found!",Toast.LENGTH_LONG).show();
                        break;
                    case 405: Toast.makeText(mContext,"Not Allowed!",Toast.LENGTH_LONG).show();
                        break;
                    case 403: Toast.makeText(mContext,"Request Unauthorized",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(mContext,"Something went wrong!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProductDataModel>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
                Toast.makeText(mContext,"Requesting Failed",Toast.LENGTH_LONG).show();
            }
        });

        return productsLiveData;
    }

}