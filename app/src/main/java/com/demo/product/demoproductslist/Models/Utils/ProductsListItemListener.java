package com.demo.product.demoproductslist.Models.Utils;

import com.demo.product.demoproductslist.Models.DataModels.CompactProduct;

public interface ProductsListItemListener {
    void onFavoriteClick(CompactProduct product);
    void onItemClick(CompactProduct product);
}
