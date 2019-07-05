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

public class ProblemiFragment extends Fragment
{
    public ProblemiFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Problemi e Disturbi");
        rootView = inflater.inflate(R.layout.lista_informazioni, container, false);
        String [] arrayNome = {"EMICRANIA", "AEREOFAGIA", "TACHICARDIA", "VESCICHE", "IPERTENSIONE", "FORFORA", "NAUSEA"};
        listView = rootView.findViewById(R.id.listViewT);
        ArrayAdapter<String> arrayAdapterNome = new ArrayAdapter<String>(getActivity(), R.layout.elemento_lista, R.id.textViewName,  arrayNome);
        listView.setAdapter(arrayAdapterNome);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                InfoProblemaFragment infP = new InfoProblemaFragment();
                Bundle arguments = new Bundle();
                arguments.putString("position", String.valueOf(position));
                infP.setArguments(arguments);

                final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, infP).addToBackStack("tag").commit();
            }
        });
        return rootView;
    }
    private ListView listView;
    private View rootView;
}