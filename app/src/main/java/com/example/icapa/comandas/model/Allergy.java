package com.example.icapa.comandas.model;

import android.graphics.drawable.Drawable;

import com.example.icapa.comandas.utils.ResourceUtils;

import java.io.Serializable;

/**
 * Created by icapa on 8/12/16.
 * Clase básica del objeto alergia
 */

public class Allergy implements Serializable{
    public static final String ALER_HUEVO="huevo";
    public static final String ALER_FRUTOS_SECOS="frutos_secos";
    public static final String ALER_MARISCO="marisco";

    private String mName;   // Nombre de la alergia
    private String mResource;  // Recurso de la imagen de la alergia

    public Allergy(String name) {
        mName = name;
    }

    public void setResource(String resource) {
        mResource = resource;
    }

    public String getName() {
        return mName;
    }

    public String getResource() {
        return mResource;
    }
}
