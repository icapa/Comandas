package com.example.icapa.comandas.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.fragments.DishesFragment;

import java.util.Date;


/**
 * Created by icapa on 10/12/16.
 */

public class DishesActivity extends AppCompatActivity {
    public static final String EXTRA_DISH = "EXTRA_DISH";
    public static final String EXTRA_OBS = "EXTRA_OBS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment_dish_list)==null){
            fm.beginTransaction()
                    .add(R.id.fragment_dish_list,new DishesFragment())
                    .commit();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        String title = getString(R.string.dishes_title);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            title = title + "  " + sdf.format(new Date());
        }


        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle(title);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
