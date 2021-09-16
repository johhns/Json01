package com.example.json01.Adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.json01.Vista.Fragmentos.Fragmento_Paises;
import com.example.json01.Vista.Fragmentos.Fragmento_Perfil;

import java.util.ArrayList;

public class AdaptadorViewPager2 extends FragmentStateAdapter {

    private ArrayList<Fragment> fragmentos = new ArrayList<>();

    public AdaptadorViewPager2(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fragmentos.add( new Fragmento_Paises() ) ;
        fragmentos.add( new Fragmento_Perfil() ) ;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentos.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentos.size() ;
    }

    // by johhns

}
