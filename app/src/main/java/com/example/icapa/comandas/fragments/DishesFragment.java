package com.example.icapa.comandas.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.activities.DetailActivity;
import com.example.icapa.comandas.activities.DishesActivity;
import com.example.icapa.comandas.activities.MenuActivity;
import com.example.icapa.comandas.adapter.DishesRecyclerViewAdapter;
import com.example.icapa.comandas.model.Dish;
import com.example.icapa.comandas.model.Menu;

import java.util.LinkedList;

/**
 * Created by icapa on 9/12/16.
 */

public class DishesFragment extends Fragment implements DishesRecyclerViewAdapter.OnDishClickListener, DishesRecyclerViewAdapter.OnDishLongClickListener {
    private static String DISHES_ARG = "DISHES_ARG";
    private LinkedList<Dish> mDishes;
    private RecyclerView mList;

    public static DishesFragment newInstance(LinkedList<Dish> dishes) {
        DishesFragment fragment = new DishesFragment();

        Bundle arguments = new Bundle();
        arguments.putSerializable(DISHES_ARG, dishes);
        fragment.setArguments(arguments);

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
        mList.setAdapter(new DishesRecyclerViewAdapter(mDishes,
                getActivity(),
                this,
                this));



        return root;
    }

    @Override
    public void onDishClick(final int position, Dish forecast, View view) {
        Log.v("DISHES_FRAGMENT","Pulsamos un cardview");
        final Activity activity = getActivity();


        if (activity.getClass() == DishesActivity.class) {
            // Para meter las opciones
            AlertDialog.Builder txtAlert = new AlertDialog.Builder(getActivity());
            final EditText input = new EditText(getActivity());
            txtAlert.setTitle(R.string.dish_observations);
            txtAlert.setView(input);
            txtAlert.setMessage(R.string.ask_observations);
            txtAlert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String extras = input.getText().toString();

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(DishesActivity.EXTRA_DISH, position);
                    if (extras.length()>0) {
                        returnIntent.putExtra(DishesActivity.EXTRA_OBS, extras);
                    }
                    activity.setResult(Activity.RESULT_OK, returnIntent);
                    activity.finish();

                }
            });
            txtAlert.show();



        }

    }

    @Override
    public void onDishLongClick(Dish dish, View view) {
        Log.v("DISHES_FRAGMENT", "PULSACION LARGAAAA");
        Intent intent = new Intent(getActivity(),DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_DISH,dish);
        startActivity(intent);



    }
}
