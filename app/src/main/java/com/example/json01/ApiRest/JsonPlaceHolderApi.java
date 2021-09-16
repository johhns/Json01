package com.example.json01.ApiRest;

import com.example.json01.Modelo.Pais;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi{

    @GET("region/europe")
    Call<ArrayList<Pais>> getPaises();

    // by johhns
}
