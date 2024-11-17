package com.sunbeaminfo.mobilesrestapiapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {
    private API api;
    private static RetroFitClient retroFitClient=null;
    RetroFitClient(){
        api=new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(API.class);
    }
    public static RetroFitClient getInstance(){
        if(retroFitClient==null)
            retroFitClient=new RetroFitClient();
        return retroFitClient;
    }
    public API getApi(){
        return api;
    }
}
