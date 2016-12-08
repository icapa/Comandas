package com.example.icapa.comandas.model;

/*
Esta clase describe el objeto mesa, que es el objeto básico
de la sala del restaurante
 */

import java.io.Serializable;

public class Table implements Serializable {
    private String mName;
    private int mNumber;

    Table(String name, int number) {
        mName = name;
        mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public int getNumber() {
        return mNumber;
    }

    @Override
    public String toString() {
        return mName;
    }
}
