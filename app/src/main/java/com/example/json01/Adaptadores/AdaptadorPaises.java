package com.example.json01.Adaptadores;

import android.app.Activity;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json01.Modelo.Pais;
import com.example.json01.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;



public class AdaptadorPaises extends RecyclerView.Adapter<AdaptadorPaises.ViewHolder> {

    ArrayList<Pais> paises ;
    Activity activity  ;
    ///private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

    public AdaptadorPaises(ArrayList<Pais>  paises, Activity activity) {
        this.paises   = paises   ;
        this.activity = activity ;
    }

    @NonNull
    @Override
    public AdaptadorPaises.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from( parent.getContext() ).inflate( R.layout.paises , null , false ) ;
        return new ViewHolder( vista ) ;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPaises.ViewHolder holder, int position) {
        final Pais pais = paises.get(position);
        holder.nombre_pais.setText( pais.getName() );
        //String urlPais = "https://www.worldometers.info/img/flags/" + pais.getFlag().toLowerCase() + "-flag.gif" ;
        String urlPais = "https://www.worldatlas.com/r/w425/img/flag/" + pais.getFlag().toLowerCase() + "-flag.jpg" ;
        Picasso.with(activity)
                .load( urlPais )
                .placeholder( R.drawable.estrella )
                .into( holder.bandera );
    }

    @Override
    public int getItemCount() {
        return paises.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bandera ;
        TextView  nombre_pais ;
        //TextView  poblacion ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bandera     = (ImageView) itemView.findViewById( R.id.imgBandera ) ;
            nombre_pais = (TextView)  itemView.findViewById( R.id.txtNombre ) ;
        }
    }

    // by johhns

}

