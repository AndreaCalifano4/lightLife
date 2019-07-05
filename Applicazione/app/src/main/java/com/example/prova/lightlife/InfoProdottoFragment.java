package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoProdottoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.informazione, container, false);

        tvNomeProd = rootView.findViewById(R.id.textViewNome);
        ivImgProd = rootView.findViewById(R.id.imageViewim);
        tvPrezzProd = rootView.findViewById(R.id.prezzoProdotto);
        tvDescProd = rootView.findViewById(R.id.textViewDescrizione);
        buttonAcquista = rootView.findViewById(R.id.buttonAcquista);

        TextView noV1 = rootView.findViewById(R.id.textViewM);
        noV1.setVisibility(View.INVISIBLE);
        TextView noV2 = rootView.findViewById(R.id.textViewMod);
        noV2.setVisibility(View.INVISIBLE);

        final Bundle arguments = getArguments();
        ivImgProd.setImageDrawable(getResources().getDrawable(arguments.getInt("foto")));
        tvNomeProd.setText(arguments.getString("nome"));
        tvPrezzProd.setText(arguments.getString("prezzo"));
        tvDescProd.setText(arguments.getString("descrizione"));

        buttonAcquista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodottoBean = new ProdottoBean(arguments.getInt("foto"), arguments.getString("nome"), arguments.getString("prezzo"), arguments.getString("descrizione"));

                if(getActivity().getSupportFragmentManager().findFragmentByTag("carrello") == null){
                    CarrelloFragment carrelloFragment = new CarrelloFragment(prodottoBean);
                    Bundle prod = new Bundle();
                    Log.i("PORCO", "1.1");
                    prod.putBoolean("flag", true);
                    carrelloFragment.setArguments(prod);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, carrelloFragment, "carrello").commit();
                }
                else{
                    Log.i("PORCO", "1.2");
                    CarrelloFragment carrelloFragment = (CarrelloFragment) getActivity().getSupportFragmentManager().findFragmentByTag("carrello");
                    Bundle prod = new Bundle();
                    prod.putBoolean("flag", false);
                    prod.putString("nomeProd", arguments.getString("nome"));
                    prod.putString("priceProd", arguments.getString("prezzo"));
                    prod.putInt("photoProd", arguments.getInt("foto"));
                    prod.putString("descrProd", arguments.getString("descrizione"));
                    carrelloFragment.setArguments(prod);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, carrelloFragment, "carrello").addToBackStack("carrello").commit();
                }
                Snackbar.make(buttonAcquista, "Aggiunto al carrello!", Snackbar.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
    private ProdottoBean prodottoBean;
    private Button buttonAcquista;
    private TextView tvNomeProd;
    private ImageView ivImgProd;
    private TextView tvDescProd;
    private TextView tvPrezzProd;
    private View rootView;
}
