package com.example.icapa.comandas.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.fragments.TablesListFragment;
import com.example.icapa.comandas.model.Table;

public class TablesActivity extends AppCompatActivity implements TablesListFragment.OnTableSelectedListener{

    private final String TABLES_ACTIVITY="TABLES_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tables);

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

    }

    @Override
    public void onTableSelectedLister(Table table, int position) {
        Log.v(TABLES_ACTIVITY,"Seleccionada mesa");
    }
}
