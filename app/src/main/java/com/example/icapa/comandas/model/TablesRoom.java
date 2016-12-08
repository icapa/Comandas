package com.example.icapa.comandas.model;


import java.util.LinkedList;

public class TablesRoom {
    private LinkedList<Table> mTables;

    public TablesRoom() {
        // Las mesas no las descargo de ningún sitio, son siempre fijas,
        // No es buena práctica, pero lo dejo sí
        mTables = new LinkedList<>();
        mTables.add(new Table("Mesa 1",1));
        mTables.add(new Table("Mesa 2",2));
        mTables.add(new Table("Mesa 3",3));
    }

    public Table getTable(int position){
        return mTables.get(position);
    }

    public int getSize(){
        return mTables.size();
    }

    public LinkedList<Table> getTables() {
        return mTables;
    }
}
