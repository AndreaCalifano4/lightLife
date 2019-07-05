package com.example.prova.lightlife;

import android.graphics.drawable.Drawable;

import java.util.GregorianCalendar;

public class Ordine {
    private String numeroOrdine;
    private String cliente;
    private int nProdotti;
    private GregorianCalendar data;
    private Drawable cestino;

    public Ordine (String numeroOrdine, String cliente, int nProdotti, GregorianCalendar data, Drawable cestino) {
        this.numeroOrdine=numeroOrdine;
        this.cliente=cliente;
        this.nProdotti=nProdotti;
        this.data=data;
        this.cestino=cestino;
    }

    public String getNumeroOrdine() {
        return this.numeroOrdine;
    }

    public void setNumeroOrdine(String numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getnProdotti() {
        return this.nProdotti;
    }

    public void setnProdotti(int nProdotti) {
        this.nProdotti = nProdotti;
    }

    public GregorianCalendar getData() {
        return this.data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public Drawable getCestino() {
        return this.cestino;
    }

    public void setCestino(Drawable cestino) {
        this.cestino = cestino;
    }

    public int getYear() {
        return this.data.get(GregorianCalendar.YEAR);
    }

    public int getMonth() {
        return this.data.get(GregorianCalendar.MONTH);
    }

    public int getDay() {
        return this.data.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public String getStringData() {
        return this.getYear()+"-"+this.getMonth()+"-"+this.getDay();
    }
}
