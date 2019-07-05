package com.example.prova.lightlife;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class VisualizzaOrdini extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizza_ordini);
        final ArrayList<Ordine> lista = ListaOrdini.getLista();
        if (lista.size() == 0) {
            AlertDialog.Builder abs = new AlertDialog.Builder(VisualizzaOrdini.this);
            abs.setMessage("La lista ordini è vuota.");
            abs.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = abs.create();
            alertDialog.show();
        }
        else {
            final ListView listView = findViewById(R.id.ListViewOrdini);
            final CustomAdapterOrdine customAdapterOrdine = new CustomAdapterOrdine(getApplicationContext(), R.layout.layout_ordine_lista, lista);
            listView.setAdapter(customAdapterOrdine);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    AlertDialog.Builder abs = new AlertDialog.Builder(VisualizzaOrdini.this);
                    abs.setMessage("Vuoi eliminare l'ordine di " + lista.get(position).getCliente() + "?");
                    abs.setNegativeButton("Annulla", null);
                    abs.setPositiveButton("Elimina", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            customAdapterOrdine.remove(lista.get(position));
                            if (lista.size() == 0) {
                                AlertDialog.Builder abs = new AlertDialog.Builder(VisualizzaOrdini.this);
                                abs.setMessage("La lista ordini è vuota.");
                                abs.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                                AlertDialog alertDialog = abs.create();
                                alertDialog.show();
                            }
                        }
                    });
                    AlertDialog alertDialog = abs.create();
                    alertDialog.show();
                }
            });
        }
    }
}
