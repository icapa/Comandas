package com.example.icapa.comandas.model;

import android.graphics.drawable.Drawable;

import com.example.icapa.comandas.utils.ResourceUtils;

import java.util.LinkedList;

/**
 * Created by icapa on 8/12/16.
 * Objeto plato, es la unidad que conforma el menu
 */

@SuppressWarnings("WeakerAccess")
public class Dish {
    private String mName;           // Nombre del plato
    private float mPrice;             // Tendrá un precio
    private int mPhoto;             // Asignada una foto, en string?¿?
    private String mObservations;   // Observaciones para el cliente
    private DishType mDishType;     // Tipo de plato, 1º, 2º o postre
    private LinkedList<Allergy> mAllergies; // Listado de alergias

    public Dish(String name, int price, int orden, String photo) {
        mName = name;
        mPrice = price;
        mPhoto = ResourceUtils.getResId(photo, Drawable.class);
        mDishType = DishType.getEnumFromInt(orden);
        mAllergies = new LinkedList<>();
    }

    public String getName() {
        return mName;
    }

    public float getPrice() {
        return mPrice;
    }

    public int getPhoto() {
        return mPhoto;
    }

    public String getObservations() {
        return mObservations;
    }

    public void setObservations(String observations) {
        mObservations = observations;
    }

    public DishType getDishType() {
        return mDishType;
    }

    public void addAllergy(Allergy allergy){
        mAllergies.add(allergy);
    }

    public LinkedList<Allergy> getAllergies() {
        return mAllergies;
    }
}


