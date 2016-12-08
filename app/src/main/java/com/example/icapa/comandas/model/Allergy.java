package com.example.icapa.comandas.model;

import android.graphics.drawable.Drawable;

import com.example.icapa.comandas.utils.ResourceUtils;

/**
 * Created by icapa on 8/12/16.
 * Clase básica del objeto alergia
 */

class Allergy {
    private String mName;   // Nombre de la alergia
    private int mResource;  // Recurso de la imagen de la alergia

    public Allergy(String name, String resource) {
        mName = name;
        mResource = ResourceUtils.getResId(resource, Drawable.class);
    }

    public String getName() {
        return mName;
    }

    public int getResource() {
        return mResource;
    }
}
