package com.example.prova.lightlife;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaProdotto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_prodotto);
        final ArrayList<Prodotto> lista=ListaProdotti.getLista();
        if (lista.size()==0) {
            AlertDialog.Builder abs=new AlertDialog.Builder(ListaProdotto.this);
            abs.setMessage("La lista prodotti è vuota.");
            abs.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog=abs.create();
            alertDialog.show();
        }
        else {
            final CustomAdapter customAdapter = new CustomAdapter(this, R.layout.layout_prodotto_lista, lista);
            final ListView listView = findViewById(R.id.ListView);
            listView.setAdapter(customAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    TextView textViewTitolo = (TextView) view.findViewById(R.id.TextViewTitolo);
                    AlertDialog.Builder abs = new AlertDialog.Builder(ListaProdotto.this);
                    abs.setMessage("Vuoi eliminare il prodotto " + textViewTitolo.getText().toString() + "?");
                    abs.setNegativeButton("annulla", null);
                    abs.setPositiveButton("elimina", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            customAdapter.remove(lista.get(position));
                            if (lista.size()==0) {
                                AlertDialog.Builder abs=new AlertDialog.Builder(ListaProdotto.this);
                                abs.setMessage("La lista prodotti è vuota.");
                                abs.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                                AlertDialog alertDialog=abs.create();
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
