package com.example.icapa.comandas.model;

/**
 * Created by icapa on 8/12/16.
 * Objeto plato, es la unidad que conforma el menu
 */

public class Dish {
    private String mName;           // Nombre del plato
    private float mPrice;             // Tendrá un precio
    private int mPhoto;             // Asignada una foto, en string?¿?
    private String mObservations;   // Observaciones para el cliente

    public Dish(String name, int price, String photo) {
        mName = name;
        mPrice = price;
        mPhoto = this.getImageResource(photo);
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

    private int getImageResource(String nombre){
        // TODO
        return 0;
    }
}

