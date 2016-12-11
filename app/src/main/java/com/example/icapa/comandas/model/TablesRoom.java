package com.example.icapa.comandas.model;


import java.util.LinkedList;

public class TablesRoom {
    private static LinkedList<Table> mTables = new LinkedList<>();

    public static void createTables(){
        mTables.add(new Table("Mesa 1",1));
        mTables.add(new Table("Mesa 2",2));
        mTables.add(new Table("Mesa 3",3));
    }


    public static Table getTable(int position){
        return mTables.get(position);
    }

    public static int getSize(){
        return mTables.size();
    }

    public static LinkedList<Table> getTables() {
        return mTables;
    }
}
