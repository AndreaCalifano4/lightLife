package com.example.prova.lightlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterOrdine extends ArrayAdapter<Ordine> {
    private ArrayList<Ordine> lista;
    private int resource;
    private LayoutInflater layoutInflater;

    public CustomAdapterOrdine(Context context, int resource, ArrayList<Ordine> lista) {
        super(context, resource, lista);
        this.lista=lista;
        this.resource=resource;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null) {
            view=this.layoutInflater.inflate(R.layout.layout_ordine_lista, null);
        }
        Ordine ordine=this.lista.get(position);
        TextView textViewOrdine, textViewCliente, textViewProdotti, textViewData;
        ImageView imageView;
        textViewOrdine=(TextView)view.findViewById(R.id.TextViewOrdine);
        textViewCliente=(TextView)view.findViewById(R.id.TextViewCliente);
        textViewProdotti=(TextView)view.findViewById(R.id.TextViewProdotti);
        textViewData=(TextView)view.findViewById(R.id.TextViewData);
        imageView=(ImageView)view.findViewById(R.id.ImageViewCestino);
        textViewOrdine.setText(ordine.getNumeroOrdine());
        textViewCliente.setText(ordine.getCliente());
        textViewProdotti.setText(ordine.getnProdotti()+"");
        textViewData.setText(ordine.getStringData());
        imageView.setImageDrawable(ordine.getCestino());
        return view;
    }
}
