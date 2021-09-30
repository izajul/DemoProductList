package com.demo.product.demoproductslist.Views.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.demo.product.demoproductslist.Models.DataModels.CompactProduct;
import com.demo.product.demoproductslist.Models.Utils.ProductsListItemListener;
import com.demo.product.demoproductslist.ViewModels.ProductViewModel;
import com.demo.product.demoproductslist.Views.Adapters.ProductsListAdapter;
import com.demo.product.demoproductslist.databinding.ActivityMainBinding;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ProductViewModel productViewModel;

    private ActivityMainBinding binding;

    private ProductsListAdapter mAdapter;
    private List<CompactProduct> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        productViewModel.getProductList().observe(this, productDataModels -> {
            productViewModel.productsFromDB().observe(this, products ->{
               productViewModel.doCompactWithDBData(productDataModels,products);
            });
        });

        productViewModel.mCompactProductLiveData.observe(this, compactProducts -> {
            progressDialog.dismiss();
                        list.clear();
            list.addAll(compactProducts);
            mAdapter.notifyDataSetChanged();
        });

        mAdapter = new ProductsListAdapter(list);

        mAdapter.addListener(new ProductsListItemListener() {
            @Override
            public void onFavoriteClick(CompactProduct product) {
                productViewModel.doFavoriteAction(product);
            }

            @Override
            public void onItemClick(CompactProduct product) {

            }
        });

        binding.listRC.setLayoutManager(new GridLayoutManager(this,2));

        binding.listRC.setAdapter(mAdapter);
    }
}