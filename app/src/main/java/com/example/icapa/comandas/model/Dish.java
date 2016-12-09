package com.example.icapa.comandas.model;

import android.graphics.drawable.Drawable;

import com.example.icapa.comandas.utils.ResourceUtils;

import java.util.LinkedList;

/**
 * Created by icapa on 8/12/16.
 * Objeto plato, es la unidad que conforma el menu
 */


public class Dish {
    private String mName;           // Nombre del plato
    private float mPrice;             // Tendrá un precio
    private String mPhoto;             // Asignada una foto, en string?¿?
    private String mObservations;   // Observaciones para el cliente
    private DishType mDishType;     // Tipo de plato, 1º, 2º o postre
    private LinkedList<Allergy> mAllergies; // Listado de alergias
    private String mDescription;

    public Dish(String name, float price, int orden, String photo, String description) {
        mName = name;
        mPrice = price;
        mPhoto = photo;
        mDishType = DishType.getEnumFromInt(orden);
        mDescription = description;
        mAllergies = new LinkedList<>();

    }

    public String getDescription() {
        return mDescription;
    }

    public String getName() {
        return mName;
    }

    float getPrice() {
        return mPrice;
    }

    public String getPhoto() {
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


