package com.example.icapa.comandas.model;

import java.util.LinkedList;

/**
 * Created by icapa on 8/12/16.
 * Este es el menu, está compuesto por los platos de los comensales
 */

public class Menu {
    private LinkedList<Dish> mDishes;
    private float mTotalPrice;

    public Menu() {
        mTotalPrice = 0.0f;
        mDishes = new LinkedList<>();
    }

    public void addDish(Dish dish){
        mDishes.add(dish);
        mTotalPrice = mTotalPrice + dish.getPrice();
    }

    public LinkedList<Dish> getDishes() {
        return mDishes;
    }

    public float getTotalPrice() {
        return mTotalPrice;
    }

    public int getDishSize(){
        return mDishes.size();
    }

    public Dish getDish(int position){
        return mDishes.get(position);
    }

    public LinkedList<Dish> getAllDishes(){
        return mDishes;
    }
}
