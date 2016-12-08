package com.example.icapa.comandas.utils;

import java.lang.reflect.Field;

/**
 * Created by icapa on 8/12/16.
 * Clase de ayuda para refactorizar algunas tareas
 */

public class ResourceUtils {
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
