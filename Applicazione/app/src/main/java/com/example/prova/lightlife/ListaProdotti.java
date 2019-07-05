package com.example.prova.lightlife;

import java.util.ArrayList;

public class ListaProdotti {
    private  static ArrayList<Prodotto> lista;
    static {
        lista= new ArrayList<Prodotto>();
    }

    public static void addProdotto (Prodotto prodotto) {
        lista.add(prodotto);
    }

    public static void removeProdotto (int position) {
        lista.remove(position);
    }

    public static Prodotto getProdotto (int position) {
        return lista.get(position);
    }

   public static ArrayList<Prodotto> getLista() {
        return lista;
   }

}
