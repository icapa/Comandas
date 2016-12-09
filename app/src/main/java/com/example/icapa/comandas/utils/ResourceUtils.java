package com.example.icapa.comandas.utils;

import android.app.Activity;
import android.content.res.Resources;

import java.lang.reflect.Field;

/**
 * Created by icapa on 8/12/16.
 * Clase de ayuda para refactorizar algunas tareas
 */

public class ResourceUtils {
    public static int getResId(String resName, Activity activity, String pac) {

        try {
            int drawableResourceId = activity.getResources().getIdentifier(resName, "drawable", pac);
            return drawableResourceId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
