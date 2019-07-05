package com.example.prova.lightlife;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.Button;

public class Prodotto {
    private String titolo;
    private double prezzo;
    private String descrizione;
    private Bitmap bitmap;
    private Drawable cestino;
    public Prodotto(String titolo, double prezzo, String descrizione, Bitmap bitmap, Drawable cestino) {
        this.titolo=titolo;
        this.prezzo=prezzo;
        this.descrizione=descrizione;
        this.bitmap=bitmap;
        this.cestino=cestino;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Drawable getCestino() {
        return this.cestino;
    }

    public void setCestino(Drawable cestino) {
        this.cestino = cestino;
    }
}
