package com.example.icapa.comandas.model;

import android.graphics.drawable.Drawable;

import com.example.icapa.comandas.utils.ResourceUtils;

/**
 * Created by icapa on 8/12/16.
 * Clase básica del objeto alergia
 */

class Allergy {
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
