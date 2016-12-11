package com.example.icapa.comandas.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.icapa.comandas.R;
import com.example.icapa.comandas.model.Allergy;
import com.example.icapa.comandas.model.Dish;
import com.example.icapa.comandas.utils.ResourceUtils;

import org.w3c.dom.Text;

/**
 * Created by icapa on 11/12/16.
 */

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DISH = "EXTRA_DISH";
    private Dish mDish;


    private TextView mDescription;
    private TextView mPrice;
    private ImageView mAlerHuevo;
    private ImageView mAlerAlmendra;
    private ImageView mAlerMarisco;
    private ImageView mPhoto;
    private TextView mObser;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Dish auxDish = (Dish) getIntent().getExtras().getSerializable(EXTRA_DISH);
        if (auxDish != null){
            mDish = auxDish;
        }





        mDescription = (TextView) findViewById(R.id.detail_description);
        mPrice = (TextView) findViewById(R.id.detail_price);

        mAlerHuevo = (ImageView) findViewById(R.id.aler_huevo);
        mAlerAlmendra = (ImageView) findViewById(R.id.aler_almendra);
        mAlerMarisco = (ImageView) findViewById(R.id.aler_marisco);
        mObser = (TextView) findViewById(R.id.detail_obser);

        mPhoto = (ImageView) findViewById(R.id.detail_photo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



        updateView();
    }

    private void updateView() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle(mDish.getName());
        }


        mPhoto.setImageResource(ResourceUtils.getResId(mDish.getPhoto(), this,this.getPackageName()));
        mDescription.setText(mDish.getDescription());
        mPrice.setText(String.format(getString(R.string.price_format),mDish.getPrice()));

        mObser.setText(mDish.getObservations());
        for (int i = 0;i<mDish.getAllergies().size();i++){
            Allergy alergy = mDish.getAllergies().get(i);
            switch (alergy.getName()){
                case Allergy.ALER_HUEVO:
                    mAlerHuevo.setImageResource(R.drawable.huevo);
                    break;
                case Allergy.ALER_FRUTOS_SECOS:
                    mAlerAlmendra.setImageResource(R.drawable.almendra);
                    break;
                case Allergy.ALER_MARISCO:
                    mAlerMarisco.setImageResource(R.drawable.marisco);
                    break;
                default:
                    break;
            }
        }
    }
}
