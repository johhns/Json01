package com.example.json01.Vista.Fragmentos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json01.Adaptadores.AdaptadorPerfil;
import com.example.json01.Modelo.Mascota;
import com.example.json01.R;

import java.util.ArrayList;

public class Fragmento_Perfil extends Fragment {

    ArrayList<Mascota> arrayMascotas2 ;
    RecyclerView recView ;


    public Fragmento_Perfil() {
        // Required empty public constructor
    }

    //
    public static Fragmento_Perfil newInstance(String param1, String param2) {
        Fragmento_Perfil fragment = new Fragmento_Perfil();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragmento_perfil, container, false);

        ImageView img_Perfil = (ImageView) v.findViewById(R.id.imgPerfil);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.peluchin);
        RoundedBitmapDrawable imagenRedondeada = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        imagenRedondeada.setCircular(true);
        img_Perfil.setImageDrawable(imagenRedondeada);

        arrayMascotas2 = new ArrayList<>();
        recView =  v.findViewById(R.id.rcViewPerfil);
        GridLayoutManager layout = new GridLayoutManager( getContext() ,2 ) ;
        recView.setLayoutManager(layout);

        crear_mascotas();

        AdaptadorPerfil adapter = new AdaptadorPerfil(arrayMascotas2,getActivity());
        recView.setAdapter(adapter);


        return v ;
    }

    private void crear_mascotas() {
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 1 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 2 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 3 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 4 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 5 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 6 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 7 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 8 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 9 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 1 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 2 ) ) ;
        arrayMascotas2.add( new Mascota( R.drawable.peluchin , "" , 3 ) ) ;
    }

    // by johhns
}
