package com.demo.product.demoproductslist.Dagger.Componets;

import com.demo.product.demoproductslist.Dagger.Modules.RetroModule;
import com.demo.product.demoproductslist.Network.APIService;

import dagger.Component;

@Component(modules = RetroModule.class)
public interface RetroComponent {
    APIService getApiService();
}
