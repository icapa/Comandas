package com.example.icapa.comandas.model;

/*
Esta clase describe el objeto mesa, que es el objeto básico
de la sala del restaurante
 */

public class Table {
    private String mName;
    private int mNumber;

    public Table(String name, int number) {
        mName = name;
        mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public int getNumber() {
        return mNumber;
    }
}
