package com.example.icapa.comandas.model;

@SuppressWarnings("ALL")
public enum DishType{
    FIRST("First",1),
    SECOND("Second",2),
    DESSERT("Dessert",3);


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
