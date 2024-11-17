package com.sunbeaminfo.mobilesrestapiapp.utils;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("/users")
    Call<JsonObject> getAllUsers();
}
