package com.criddam.doctor.demoproductslist.Models.Utils;

import com.criddam.doctor.demoproductslist.Models.DataModels.CompactProduct;

public interface ProductsListItemListener {
    void onFavoriteClick(CompactProduct product);
    void onItemClick(CompactProduct product);
}
