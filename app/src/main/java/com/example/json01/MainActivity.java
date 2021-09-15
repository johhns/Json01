package com.example.json01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtJson ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJson = findViewById( R.id.txtJSON ) ;
        
        obtenerPaises();


    }

    private void obtenerPaises() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create( JsonPlaceHolderApi.class ) ;

        Call<List<Pais>> call = jsonPlaceHolderApi.getPaises();
        call.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response) {
                if ( !response.isSuccessful() ){
                    txtJson.setText( "Codigo = " + response.code() );
                }

                List<Pais> listPosts = response.body() ;
                for ( Pais p : listPosts ) {
                    String contenido = "" ;
                    contenido += "Pais = " + p.getAlpha3Code() + "\n" ;
                    contenido += "Nombre = " + p.getName() + "\n" ;
                    contenido += "Bandera = " + p.getFlag() + "\n" ;
                    txtJson.append( contenido );
                }

            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {
                txtJson.setText( t.getMessage().toString() );
            }
        });
    }
}
