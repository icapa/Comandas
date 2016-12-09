package com.example.icapa.comandas.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.model.Dish;
import com.example.icapa.comandas.model.Menu;

import java.util.LinkedList;

/**
 * Created by icapa on 9/12/16.
 */

public class DishesFragment extends Fragment {
    private static String DISHES_ARG = "DISHES_ARG";
    private LinkedList<Dish> mDishes;
    private RecyclerView mList;

    public static DishesFragment newInstance() {
        DishesFragment fragment = new DishesFragment();
        /*
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARG_CITY, city);
        fragment.setArguments(arguments);
        */
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            // Nos pasan argumentos, es un determinado menu
            mDishes = (LinkedList<Dish>) getArguments().getSerializable(DISHES_ARG);
        }
        else{
            // No nos pasan nada, cargamos todos los platos
            mDishes = Menu.getMenu();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Se crea la vista
        View root = inflater.inflate(R.layout.fragment_dishes, container, false);
        mList = (RecyclerView) root.findViewById(android.R.id.list);
        // Queremos que se vea como una lista
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Si queremos que se vea como una tabla usaríamos GridLayoutManager
//        mList.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        // Le indicamos cómo animar las apariciones y desapariciones de elementos
        mList.setItemAnimator(new DefaultItemAnimator());

        // Por último RecyclerView necesita un adapter
        mList.setAdapter(new ForecastRecyclerViewAdapter(new LinkedList<Forecast>(), getActivity(), this));



        return root;
    }
}
