package com.example.icapa.comandas.model;

@SuppressWarnings("ALL")
public enum DishType{
    FIRST("1º Plato",1),
    SECOND("2º Plato",2),
    DESSERT("Postre",3);


    private String stringValue;
    private int intValue;
    DishType(String toString, int value) {
        stringValue = toString;
        intValue = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static DishType getEnumFromInt(int position){
        switch (position){
            case 1:
                return FIRST;
            case 2:
                return SECOND;
            case 3:
                return DESSERT;
            default:
                return null;
        }

    }

}
