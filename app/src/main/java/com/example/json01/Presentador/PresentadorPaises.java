package com.example.json01.Presentador;

import android.content.Context;
import android.widget.Toast;

import com.example.json01.ApiRest.JsonPlaceHolderApi;
import com.example.json01.Modelo.Pais;
import com.example.json01.Vista.Fragmentos.Fragmento_Paises;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PresentadorPaises {

    private Fragmento_Paises fragmento ;
    private Context contexto  ;
    private ArrayList<Pais> paises ;

    public PresentadorPaises(Fragmento_Paises fragmento, Context contexto) {
        this.fragmento = fragmento;
        this.contexto  = contexto ;
        obtenerPaises();
    }

    private void obtenerPaises() {

        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl("https://restcountries.eu/rest/v2/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build() ;
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create( JsonPlaceHolderApi.class ) ;

        Call<ArrayList<Pais>> call = jsonPlaceHolderApi.getPaises();
        call.enqueue(new Callback<ArrayList<Pais>>() {
            @Override
            public void onResponse(Call<ArrayList<Pais>> call, Response<ArrayList<Pais>> response) {
                if ( !response.isSuccessful() ){
                    Toast.makeText( contexto , "Codigo respuesta : " + response.code() ,Toast.LENGTH_LONG ).show();
                }
                paises = response.body() ;
                mostrarPaises();

            }

            @Override
            public void onFailure(Call<ArrayList<Pais>> call, Throwable t) {
                Toast.makeText( contexto , "Error : " + t.getMessage().toString() ,Toast.LENGTH_LONG ).show();
            }
        });
    }

    private void mostrarPaises() {
      fragmento.inicializarAdaptadorRV( fragmento.crearAdaptador(paises) );
      fragmento.generarLayout();
    }

    // by johhns
}
