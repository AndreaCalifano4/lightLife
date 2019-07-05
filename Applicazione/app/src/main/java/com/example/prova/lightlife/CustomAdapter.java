package com.example.prova.lightlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Prodotto> {
    private int resource;
    private LayoutInflater layoutInflater;
    private ArrayList<Prodotto> lista;

    public CustomAdapter(Context context, int resource, ArrayList<Prodotto> lista) {
        super(context, resource, lista);
        this.lista=lista;
        this.resource=resource;
        this.layoutInflater=LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v==null) {
            v=this.layoutInflater.inflate(R.layout.layout_prodotto_lista, null);
        }
        Prodotto prodotto=lista.get(position);
        ImageView imageView, imageViewDelete;
        TextView textViewTitolo, textViewPrezzo, textViewDescrizione;
        imageView=v.findViewById(R.id.ImageView);
        imageViewDelete=v.findViewById(R.id.ImageViewDelete);
        textViewTitolo=v.findViewById(R.id.TextViewTitolo);
        textViewPrezzo=v.findViewById(R.id.TextViewPrezzo);
        textViewDescrizione=v.findViewById(R.id.TextViewDescrizione);
        imageView.setImageBitmap(prodotto.getBitmap());
        imageViewDelete.setImageDrawable(prodotto.getCestino());
        textViewTitolo.setText(prodotto.getTitolo());
        textViewPrezzo.setText(prodotto.getPrezzo()+"");
        textViewDescrizione.setText(prodotto.getDescrizione());
        return v;
    }
}
