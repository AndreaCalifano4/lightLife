package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RimediFragment extends Fragment
{
    public RimediFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Rimedi");
        rootView = inflater.inflate(R.layout.lista_informazioni, container, false);
        String [] arrayNome = {"ACETOSA", "ALOE VERA", "ARNICA", "GELSOMINO", "ENOTERA", "UVA URSULINA", "AGNOCASTO"};
        listView = rootView.findViewById(R.id.listViewT);
        ArrayAdapter<String> arrayAdapterNome = new ArrayAdapter<String>(getActivity(), R.layout.elemento_lista, R.id.textViewName,  arrayNome);
        listView.setAdapter(arrayAdapterNome);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                InfoRimedioFragment infR = new InfoRimedioFragment();
                Bundle arguments = new Bundle();
                arguments.putString("position", String.valueOf(position));
                infR.setArguments(arguments);

                final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, infR).addToBackStack("tag").commit();
            }
        });
        return rootView;
    }
    private ListView listView;
    private View rootView;
}