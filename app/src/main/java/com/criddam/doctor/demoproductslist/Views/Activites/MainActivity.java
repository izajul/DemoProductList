package com.criddam.doctor.demoproductslist.Views.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.criddam.doctor.demoproductslist.Dagger.Componets.DaggerRetroComponent;
import com.criddam.doctor.demoproductslist.Dagger.Componets.RetroComponent;
import com.criddam.doctor.demoproductslist.Models.DataModels.ProductDataModel;
import com.criddam.doctor.demoproductslist.R;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  RetroComponent component = DaggerRetroComponent.create();

        component.getApiService().getProductList().enqueue(new Callback<List<ProductDataModel>>() {
            @Override
            public void onResponse(Call<List<ProductDataModel>> call, Response<List<ProductDataModel>> response) {
                Log.d(TAG, "onResponse: "+ new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<List<ProductDataModel>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });*/
    }
}