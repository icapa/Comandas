package com.example.icapa.comandas.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.fragments.DishesFragment;
import com.example.icapa.comandas.model.Menu;
import com.example.icapa.comandas.model.Table;

/**
 * Created by icapa on 10/12/16.
 */

public class MenuActivity extends AppCompatActivity {
    public static final String EXTRA_TABLE = "EXTRA_TABLE";
    private Table mTable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Recogemos la mesa
        setContentView(R.layout.activity_menu);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment_menu_list)==null){
            mTable = (Table) getIntent().getSerializableExtra(EXTRA_TABLE);
            DishesFragment dishesFragment = DishesFragment.newInstance(mTable.getMenu().getDishes());
            fm.beginTransaction()
                    .add(R.id.fragment_menu_list,dishesFragment)
                    .commit();

        }


    }
}
