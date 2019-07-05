package com.example.prova.lightlife;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class BitmapImageCorrente {
    private static ArrayList<Bitmap> lista;
    static {
        lista=new ArrayList<Bitmap>();
    }

    public static void addBitmap(Bitmap bitmap) {
        lista.add(0, bitmap);
    }

    public static ArrayList<Bitmap> getLista() {
        return lista;
    }
}
