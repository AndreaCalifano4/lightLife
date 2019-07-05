package com.example.prova.lightlife;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarrelloFragment extends Fragment {
    @SuppressLint("ValidFragment")
    public CarrelloFragment(ProdottoBean prodotto){
        this.carrello.add(prodotto);
    }
    public CarrelloFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.carrello, container, false);

        prezzoTot = rootView.findViewById(R.id.prezzoTot);
        acquista = rootView.findViewById(R.id.acquista);

        GridView gridView = rootView.findViewById(R.id.gridViewCarrello);
        Bundle b = getArguments();

        ultimoOrdine = b.getBoolean("ultimoOrdine", false);
        if(ultimoOrdine){
            gridView.setAdapter(new CustomAdapterCarrello(getActivity(), ultimoOrdineList));
            double j = 0.00;
            for (int i = 0; i < ultimoOrdineList.size(); i++){
                j += Double.parseDouble(ultimoOrdineList.get(i).getPrezzo());
            }
            prezzoTot.setText("Totale: "+j + " €");
            carrello = new ArrayList<>();
            for (int i = 0; i < ultimoOrdineList.size(); i++){
                carrello.add(new ProdottoBean(ultimoOrdineList.get(i).getPhoto(), ultimoOrdineList.get(i).getNome(), ultimoOrdineList.get(i).getPrezzo(), ultimoOrdineList.get(i).getDescrizione()));
            }
        } else {
            flag = b.getBoolean("flag", false);
            if(flag){
                if(getActivity().getSupportFragmentManager().findFragmentByTag("carrelloVuoto") == null){
                    gridView.setAdapter(new CustomAdapterCarrello(getActivity(), carrello));
                    prezzoTot.setText("Tot: "+carrello.get(0).getPrezzo() + " €");
                } else{
                    gridView.setAdapter(new CustomAdapterCarrello(getActivity(), carrello));
                    prezzoTot.setText("Tot: "+carrello.get(0).getPrezzo() + " €");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, getActivity().getSupportFragmentManager().findFragmentByTag("carrello")).commit();
                }
            } else {
                ProdottoBean prodotto = new ProdottoBean(b.getInt("photoProd"), b.getString("nomeProd"), b.getString("priceProd"), b.getString("descrProd"));
                carrello.add(prodotto);
                gridView = rootView.findViewById(R.id.gridViewCarrello);
                gridView.setAdapter(new CustomAdapterCarrello(getActivity(), carrello));
                double j = 0.00;
                for (int i = 0; i < carrello.size(); i++){
                    j += Double.parseDouble(carrello.get(i).getPrezzo());
                }
                prezzoTot.setText("Totale: "+j + " €");
            }
        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InfoProdottoFragment infP = new InfoProdottoFragment();
                Bundle arguments = new Bundle();
                arguments.putInt("foto", carrello.get(position).getPhoto());
                arguments.putString("nome", carrello.get(position).getNome());
                arguments.putString("prezzo", carrello.get(position).getPrezzo());
                arguments.putString("descrizione", carrello.get(position).getDescrizione());
                infP.setArguments(arguments);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, infP).addToBackStack("infoProdotto").commit();
            }
        });
        acquista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ultimoOrdineList = new ArrayList<>();
                for (int i = 0; i < carrello.size(); i++){
                    ultimoOrdineList.add(new ProdottoBean(carrello.get(i).getPhoto(), carrello.get(i).getNome(), carrello.get(i).getPrezzo(), carrello.get(i).getDescrizione()));
                }
                carrello = new ArrayList<>();
                Snackbar.make(acquista, "Acquisto Effettuato!", Snackbar.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle bo = new Bundle();
                bo.putBoolean("trans", true);
                bo.putBoolean("ultimoOrdine", true);
                AreaUtenteFragment areaUtenteFragment = new AreaUtenteFragment();
                areaUtenteFragment.setArguments(bo);
                transaction.replace(R.id.container, areaUtenteFragment, "areaUtente").commit();
            }
        });
        return rootView;
    }
    private ImageView del;
    private boolean ultimoOrdine = false;
    private boolean flag = false;
    private ArrayList<ProdottoBean> carrello = new ArrayList<>();
    private ArrayList<ProdottoBean> ultimoOrdineList = new ArrayList<>();
    private TextView prezzoTot;
    private Button acquista;
    private View rootView;
}
