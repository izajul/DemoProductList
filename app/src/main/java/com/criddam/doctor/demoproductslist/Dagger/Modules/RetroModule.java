package com.criddam.doctor.demoproductslist.Dagger.Modules;

import com.criddam.doctor.demoproductslist.Network.APIService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class RetroModule {

    @Provides
    static Gson provideGson(){
        return  new GsonBuilder().create();
    }

    @Provides
    static OkHttpClient provideOkHttpClient(){
        return new OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    static Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl("https://labapi.yuma-technology.co.uk:8443/delivery/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    static APIService provideApiService(Retrofit retrofit){
        return retrofit.create(APIService.class);
    }
}
