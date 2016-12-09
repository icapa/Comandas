package com.example.icapa.comandas.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by icapa on 8/12/16.
 * Este es el menu, está compuesto por los platos de los comensales
 */

public class Menu {

    private final static String MENU_URL="http://www.mocky.io/v2/584abf9b1000001114fb01fc";
    private static LinkedList<Dish> mDishes = new LinkedList<>();
    private LinkedList<Dish> mMenu;
    private float mTotalPrice;

    public Menu() {
        mTotalPrice = 0.0f;
        mMenu = new LinkedList<>();

    }

    public void addDish(Dish dish){
        mMenu.add(dish);
        mTotalPrice = mTotalPrice + dish.getPrice();
    }

    public static LinkedList<Dish> getMenu(){
        return mDishes;
    }

    public LinkedList<Dish> getDishes() {
        return mMenu;
    }

    public float getTotalPrice() {
        return mTotalPrice;
    }

    public int getDishSize(){
        return mMenu.size();
    }

    public Dish getDish(int position){
        return mMenu.get(position);
    }

    public LinkedList<Dish> getAllDishes(){
        return mMenu;
    }

    // Funcion estática para descargar el menu
    public static LinkedList<Dish> downloadMenu(){

        try {
            URLConnection connection = new URL(MENU_URL).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            /*
            "nombre": "Patatas con chorizo",
            "orden": "1",
            "precio": "5.50",
            "foto": "patatas_con_chorizo",
            "alergias": [],
            "descripcion":
             */


            JSONObject jsonRoot = new JSONObject(sb.toString());
            JSONArray menu = jsonRoot.getJSONArray("menu");
            for (int i = 0; i < menu.length(); i++) {
                JSONObject currentDish = menu.getJSONObject(i);
                String name = currentDish.getString("nombre");
                String description = currentDish.getString("descripcion");
                int type = currentDish.getInt("orden");
                float price = (float)currentDish.getDouble("precio");
                JSONArray arrayAllergens = currentDish.getJSONArray("alergias");
                ArrayList<String> allergens = new ArrayList<>();
                for (int j = 0; j < arrayAllergens.length(); j++) {
                    String currentAllergen = arrayAllergens.getString(j);
                    allergens.add(currentAllergen);
                }
                String image = currentDish.getString("foto");

                Dish dish = new Dish(name,price,type,image,description);
                mDishes.add(dish);
            }

            return mDishes;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
