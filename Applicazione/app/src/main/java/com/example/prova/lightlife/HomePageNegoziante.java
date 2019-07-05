package com.example.prova.lightlife;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class HomePageNegoziante extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_negoziante);
        caricaOrdini();
    }


    public void aggiungiProdotto(View view) {
        Intent i= new Intent(getApplicationContext(), AggiungiProdotto.class);
        startActivity(i);
    }

    public void homePage(View v){
        Intent login = new Intent(getApplicationContext(), HomePageNegoziante.class);
        startActivity(login);
    }

    public void logOut(View v){
        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(login);
        finish();
    }

    public void visualizzaListaProdotti(View view) {
        Intent i= new Intent(getApplicationContext(), ListaProdotto.class);
        startActivity(i);
    }


    public void visualizzaOrdini(View view) {
        Intent intent= new Intent(getApplicationContext(), VisualizzaOrdini.class);
        startActivity(intent);
    }

    private void caricaOrdini() {
        ListaOrdini.addOrdine(new Ordine("01", "Adal", 3, new GregorianCalendar(2019, 2, 21), getResources().getDrawable(R.drawable.delete)));
        ListaOrdini.addOrdine(new Ordine("02", "Carmine", 4, new GregorianCalendar(2019, 4, 20), getResources().getDrawable(R.drawable.delete)));
        ListaOrdini.addOrdine(new Ordine("03", "Donato", 7, new GregorianCalendar(2018, 8, 11), getResources().getDrawable(R.drawable.delete)));
    }

}
