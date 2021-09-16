package com.example.json01.Vista;

/* Proyecto : Tarea de la semana 1 - curso avanzado de android - coursera
*  Autor    : Juan Sanchez
*  Nota     : no use instagram porque se podia vencer el token, durante el tiempo
*             que se iban a tardar el calificar la tarea, pero se mantiene la
*             funcionalidad requerida
* */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.json01.Adaptadores.AdaptadorViewPager2;
import com.example.json01.ApiRest.JsonPlaceHolderApi;
import com.example.json01.Modelo.Pais;
import com.example.json01.R;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Toolbar barra1 ;
    private TabLayout tabs ;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra1 = findViewById( R.id.barra_ppl ) ;
        tabs = findViewById(R.id.miTabLayout1);
        viewPager = findViewById(R.id.viewPager1);

        viewPager.setAdapter( new AdaptadorViewPager2( getSupportFragmentManager() , getLifecycle() ) );
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.selectTab( tabs.getTabAt(position) );
            }
        });

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        } );

        if ( barra1 != null ){
            setSupportActionBar(barra1);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcionSeleccionada = item.getItemId() ;
        switch (opcionSeleccionada ){
            case R.id.acerca:
                Intent opcion1 = new Intent(this, AcercaDe.class) ;
                startActivity(opcion1);
                break;
            case R.id.contactos:
                Intent opcion2 = new Intent(this, Contacto.class) ;
                startActivity(opcion2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

   // by johhns
}
