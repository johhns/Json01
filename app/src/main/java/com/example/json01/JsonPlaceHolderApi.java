package com.example.json01;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi{

    @GET("region/americas")
    Call<List<Pais>> getPaises();

}
