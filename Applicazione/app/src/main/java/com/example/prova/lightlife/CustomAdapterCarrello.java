package com.example.prova.lightlife;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapterCarrello extends BaseAdapter {
    private Context context;
    private ArrayList<ProdottoBean> prodotti;

    public CustomAdapterCarrello(Context con, ArrayList<ProdottoBean> prodotti) {
        this.context = con;
        this.prodotti = prodotti;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.elemento_carrello, parent, false);

        ImageView img = row.findViewById(R.id.img_prod);
        img.setImageDrawable(context.getResources().getDrawable(prodotti.get(position).getPhoto()));

        TextView price = row.findViewById(R.id.prezzo_prod);
        price.setText(prodotti.get(position).getPrezzo() + " €");

        TextView nome = row.findViewById(R.id.nome_prod);
        nome.setText(prodotti.get(position).getNome());

        ImageView del = row.findViewById(R.id.deleteProd);
        del.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_cancel_black_24dp));
        del.setTag(position);

        /*
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("PORCO", String.valueOf(position));
                prodotti.remove(position);
                Fragment f = new Fragment();
                if(position == 0){
                    f.getActivity().getSupportFragmentManager().beginTransaction().remove(f.getActivity().getSupportFragmentManager().findFragmentByTag("carrello")).commit();
                   // f.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new CarrelloVuotoFragment()).commit();
                } else {
                    f.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, f.getActivity().getSupportFragmentManager().findFragmentByTag("carrello")).commit();
                }
                //carrello.remove(p);
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, getActivity().getSupportFragmentManager().findFragmentByTag("carrello")).commit();
            }
        });
        */

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