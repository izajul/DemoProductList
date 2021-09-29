package com.criddam.doctor.demoproductslist.Dagger.Componets;

import com.criddam.doctor.demoproductslist.Dagger.Modules.RetroModule;
import com.criddam.doctor.demoproductslist.Network.APIService;

import dagger.Component;

@Component(modules = RetroModule.class)
public interface RetroComponent {
    APIService getApiService();
}
