package com.example.json01.Vista.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.json01.Adaptadores.AdaptadorPaises;
import com.example.json01.Modelo.Pais;
import com.example.json01.Presentador.PresentadorPaises;
import com.example.json01.R;

import java.util.ArrayList;

public class Fragmento_Paises extends Fragment {

    private RecyclerView reciclerView ;
    private PresentadorPaises presentador ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragmento_paises, container, false);
        reciclerView = vista.findViewById( R.id.rcView1 ) ;
        presentador  = new PresentadorPaises( this , getContext()  ) ;//// ??????
        return vista ;
    }

    public void generarLayout(){
        reciclerView.setLayoutManager(new GridLayoutManager( getContext() ,2  ));
    }

    public AdaptadorPaises crearAdaptador(ArrayList<Pais> paises) {
        AdaptadorPaises adapter = new AdaptadorPaises( paises ,getActivity() );
        return adapter;
    }

    public void inicializarAdaptadorRV(AdaptadorPaises adaptador) {
        reciclerView.setAdapter(adaptador);
    }


    // by johhns
}