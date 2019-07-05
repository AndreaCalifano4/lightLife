package com.example.prova.lightlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapterProdotti extends BaseAdapter {
    private Context context;
    private ArrayList<ProdottoBean> prodotti;

    public CustomAdapterProdotti(Context con, ArrayList<ProdottoBean> prodotti) {
        this.context = con;
        this.prodotti = prodotti;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.elemento_negozio, parent, false);

        ImageView img = row.findViewById(R.id.img_prod);
        img.setImageDrawable(context.getResources().getDrawable(prodotti.get(position).getPhoto()));

        TextView price = row.findViewById(R.id.prezzo_prod);
        price.setText(prodotti.get(position).getPrezzo() + " €");

        TextView nome = row.findViewById(R.id.nome_prod);
        nome.setText(prodotti.get(position).getNome());

        return row;
    }

    @Override
    public int getCount() {
        return prodotti.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}