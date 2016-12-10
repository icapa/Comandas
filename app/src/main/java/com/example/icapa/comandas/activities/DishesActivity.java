package com.example.icapa.comandas.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.fragments.DishesFragment;

/**
 * Created by icapa on 10/12/16.
 */

public class DishesActivity extends AppCompatActivity {
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
    }
}
