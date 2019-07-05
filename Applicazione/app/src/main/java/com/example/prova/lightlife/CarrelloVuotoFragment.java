package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CarrelloVuotoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.carrello_vuoto, container, false);

        prodNull = rootView.findViewById(R.id.prodNull);
        addProd = rootView.findViewById(R.id.addProdotti);

        addProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                getActivity().setTitle("Negozio");
                transaction.replace(R.id.container, new NegozioFragment()).addToBackStack("tag").commit();
            }
        });

        return rootView;
    }
    private View rootView;
    private Button addProd;
    private TextView prodNull;
}
