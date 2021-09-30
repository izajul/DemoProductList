package com.criddam.doctor.demoproductslist.Views.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.criddam.doctor.demoproductslist.Models.DataModels.ProductDataModel;
import com.criddam.doctor.demoproductslist.R;
import com.criddam.doctor.demoproductslist.databinding.ProductListRowBinding;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.MyViewHolder> {

    private List<ProductDataModel> list;

    public ProductsListAdapter(List<ProductDataModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ProductListRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductDataModel item = list.get(position);

        holder.binding.desc.setText(item.getDescription());
        holder.binding.shortDesc.setText(item.getShortName());

        if (item.getFiles()!=null){
            String fileUuid = item.getFiles().get(0).getFileUuid();
            Glide
                    .with(holder.itemView.getContext())
                    .load("https://labapi.yuma-technology.co.uk:8443/delivery/product/"
                            +item.getProductUuid()
                            +"/file/"+fileUuid)
                    .error(R.drawable.default_img)
                    .placeholder(R.drawable.image_loader)
                    .into(holder.binding.img);
        }

        holder.binding.favoriteImg.setOnClickListener( view -> {
            // TODO: 9/30/2021 :: Store & remove favorite from SQL
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ProductListRowBinding binding;
        public MyViewHolder(@NonNull ProductListRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
