package com.criddam.doctor.demoproductslist.Views.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.criddam.doctor.demoproductslist.Dagger.Componets.DaggerRetroComponent;
import com.criddam.doctor.demoproductslist.Dagger.Componets.RetroComponent;
import com.criddam.doctor.demoproductslist.Models.DataModels.ProductDataModel;
import com.criddam.doctor.demoproductslist.R;
import com.criddam.doctor.demoproductslist.ViewModels.ProductViewModel;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);


        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        productViewModel.getProductList().observe(this, productDataModels -> {
            progressDialog.dismiss();


        });
    }
}