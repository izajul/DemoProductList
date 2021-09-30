package com.demo.product.demoproductslist.Views.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.demo.product.demoproductslist.Models.DataModels.CompactProduct;
import com.demo.product.demoproductslist.Models.DataModels.ProductDataModel;
import com.demo.product.demoproductslist.Models.Utils.ProductsListItemListener;
import com.demo.product.demoproductslist.R;
import com.demo.product.demoproductslist.databinding.ProductListRowBinding;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.MyViewHolder> {

    private List<CompactProduct> list;
    @Nullable private ProductsListItemListener listener;

    public void addListener(ProductsListItemListener listener){
        this.listener = listener;
    }

    public ProductsListAdapter(List<CompactProduct> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ProductListRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductDataModel item = list.get(position).getProductDataModel();

        holder.binding.desc.setText(item.getDescription());
        holder.binding.shortDesc.setText(item.getShortName());

        if (list.get(position).getDbProduct()!=null){
            holder.binding.favoriteImg.setColorFilter(
                    ContextCompat.getColor(holder.binding.getRoot().getContext(), R.color.red),
                    android.graphics.PorterDuff.Mode.MULTIPLY);
        }

        if (item.getFiles()!=null){
            String fileUuid = item.getFiles().get(0).getFileUuid();
            Glide
                    .with(holder.binding.getRoot().getContext())
                    .load("https://labapi.yuma-technology.co.uk:8443/delivery/product/"
                            +item.getProductUuid()
                            +"/file/"+fileUuid)
                    .error(R.drawable.default_img)
                    .placeholder(R.drawable.image_loader)
                    .into(holder.binding.img);
        }

        holder.binding.favoriteImg.setOnClickListener( view -> {
            if (listener!=null) listener.onFavoriteClick(list.get(position));
        });

        holder.binding.getRoot().setOnClickListener( view ->{
            if (listener!=null) listener.onItemClick(list.get(position));
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
