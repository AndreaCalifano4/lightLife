package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PreferitiFragment extends Fragment {
    public PreferitiFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Preferiti");
        rootView = inflater.inflate(R.layout.carrello, container, false);



        return rootView;
    }
    private View rootView;
}
