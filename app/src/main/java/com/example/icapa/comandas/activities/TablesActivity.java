package com.example.icapa.comandas.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.fragments.DishesFragment;
import com.example.icapa.comandas.fragments.TablesListFragment;
import com.example.icapa.comandas.model.Menu;
import com.example.icapa.comandas.model.Table;
import com.example.icapa.comandas.utils.DownloadMenu;

import java.util.LinkedList;

public class TablesActivity extends AppCompatActivity implements TablesListFragment.OnTableSelectedListener{

    private final String TABLES_ACTIVITY="TABLES_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tables);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle(R.string.table_list);
        }

        // Cargamos a mano el fragment
        FragmentManager fm = getFragmentManager();

        // Hay sitio para la lista??
        if (findViewById(R.id.fragment_table_list) != null){
            // Quiere decir que hay sitio para colarlo
            if (fm.findFragmentById(R.id.fragment_table_list) == null){
                fm.beginTransaction()
                        .add(R.id.fragment_table_list, new TablesListFragment())
                        .commit();
            }
        }
        if (findViewById(R.id.fragment_menu_list) != null){
            if (fm.findFragmentById(R.id.fragment_menu_list) == null){

                fm.beginTransaction()
                        .add(R.id.fragment_menu_list,new DishesFragment())
                        .commit();
            }
        }


        // Bajamos el menu
        downloadMenu();

    }

    @Override
    public void onTableSelectedLister(Table table, int position) {
        Log.v(TABLES_ACTIVITY,"Seleccionada mesa");
        FragmentManager fm = getFragmentManager();

        if (findViewById(R.id.fragment_menu_list) != null){


            DishesFragment dishFragment = (DishesFragment) fm.findFragmentById(R.id.fragment_menu_list);

            if (dishFragment != null) {
                DishesFragment newDishesFragment = DishesFragment.newInstance(table.getMenu().getDishes());


                // Refresh
                FragmentTransaction ft = fm.beginTransaction();
                ft.remove(dishFragment);
                ft.replace(R.id.fragment_menu_list, newDishesFragment);
                ft.addToBackStack(null);
                ft.commit();

            }


        }else{
            Intent intent = new Intent(this,MenuActivity.class);
            intent.putExtra(MenuActivity.EXTRA_TABLE,position);
            startActivity(intent);
        }

    }

    // Extra functions
    public void downloadMenu(){
        if (Menu.getMenu().size()==0){
            DownloadMenu downloadMenu = new DownloadMenu((ViewGroup) findViewById(R.id.fragment_table_list), this);
            downloadMenu.execute();
        }
    }
}
