package com.example.prova.lightlife;

import java.util.ArrayList;

public class ListaOrdini {
    private static ArrayList<Ordine> listaOrdini;

    static {
        listaOrdini= new ArrayList<Ordine>();
    }

    public static void addOrdine(Ordine ordine) {
        listaOrdini.add(ordine);
    }

    public static void removeOrdine (int position) {
        listaOrdini.remove(position);
    }

    public static Ordine getOrdine (int position) {
        return listaOrdini.get(position);
    }

    public static ArrayList<Ordine> getLista() {
        return listaOrdini;
    }
}
