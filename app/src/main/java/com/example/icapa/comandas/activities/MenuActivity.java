package com.example.icapa.comandas.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.fragments.DishesFragment;
import com.example.icapa.comandas.model.Dish;
import com.example.icapa.comandas.model.Menu;
import com.example.icapa.comandas.model.Table;
import com.example.icapa.comandas.model.TablesRoom;

/**
 * Created by icapa on 10/12/16.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_TABLE = "EXTRA_TABLE";
    public static final int REQUEST_ADD_DISH = 1;

    private Table mTable;
    private FloatingActionButton mFloatingActionButton;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Recogemos la mesa
        setContentView(R.layout.activity_menu);




        int auxTablePosition = getIntent().getIntExtra(EXTRA_TABLE,-1);
        if (auxTablePosition != -1){
            mTable = TablesRoom.getTable(auxTablePosition);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle(mTable.getName());
        }



        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment_menu_list)==null){
            DishesFragment dishesFragment = DishesFragment.newInstance(mTable.getMenu().getDishes());
            fm.beginTransaction()
                    .add(R.id.fragment_menu_list,dishesFragment)
                    .commit();

        }

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.add_dish_button);

        mFloatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int vista = view.getId();
        switch (vista){
            case R.id.add_dish_button:
                Log.v("MenuActivity","ADD BUTON");
                Intent intent = new Intent(this,DishesActivity.class);
                startActivityForResult(intent,REQUEST_ADD_DISH);

                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== REQUEST_ADD_DISH){
            // Volvemos de la pantalla de menu
            if (resultCode==RESULT_OK){
                // Recogemos los datos
                int dishSelected = data.getIntExtra(DishesActivity.EXTRA_DISH,-1);
                String observations = data.getStringExtra(DishesActivity.EXTRA_OBS);
                if (dishSelected>=0){
                    // Si hay un plato seleccionado
                    Dish dish = Menu.getMenu().get(dishSelected);
                    Dish newDish = new Dish(dish.getName(),
                            dish.getPrice(),
                            dish.getDishType().toNumber(),
                            dish.getPhoto(),
                            dish.getDescription(),
                            dish.getAllergies());

                    if (observations!=null && observations.length()>0){
                        newDish.setObservations(observations);
                    }
                    mTable.getMenu().addDish(newDish);

                    recreate();
                }
            }
        }else if (requestCode == Activity.RESULT_CANCELED){
            // No hacemos nada
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_table_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_total_price:
                showTotalMenuPrice();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showTotalMenuPrice(){
        View rootView = findViewById(R.id.root);
        Toast toast = new Toast(this);
        String priceTxt = String.format(getString(R.string.total_price)+": "+getString(R.string.price_format),mTable.getMenu().getTotalPrice());

        Snackbar.make(rootView,priceTxt,Snackbar.LENGTH_LONG).show();

    }
}
