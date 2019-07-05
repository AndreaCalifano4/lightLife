package com.example.prova.lightlife;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class AreaUtenteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle transb = getArguments();
        trans = transb.getBoolean("trans", false);
        if(trans){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new CarrelloVuotoFragment()).commit();
        } else {
            rootView = inflater.inflate(R.layout.area_utente, container, false);
            sqliteHelper = new SqliteHelper(getActivity());

            nome = rootView.findViewById(R.id.areaNome);
            cognome = rootView.findViewById(R.id.areaCognome);
            mail = rootView.findViewById(R.id.areaMail);
            password = rootView.findViewById(R.id.areaPass);
            modB = rootView.findViewById(R.id.modB);
            modNome = rootView.findViewById(R.id.modNome);
            modCognome = rootView.findViewById(R.id.modCognome);
            modMail = rootView.findViewById(R.id.modMail);
            modPass = rootView.findViewById(R.id.modPass);
            buttonSave = rootView.findViewById(R.id.saveB);
            ultimoOrdine = rootView.findViewById(R.id.ultimoOrdine);
            acquistaDiNuovo = rootView.findViewById(R.id.acquistaDiNuovo);

            final Bundle b = getArguments();
            final User u = sqliteHelper.getUtente(b.getString("email"));

            final String id = u.id;
            nome.setText(u.userName);
            cognome.setText(u.surname);
            mail.setText(u.email);
            password.setText(u.password);

            modB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nome.setVisibility(View.INVISIBLE);
                    modNome.setVisibility(View.VISIBLE);
                    cognome.setVisibility(View.INVISIBLE);
                    modCognome.setVisibility(View.VISIBLE);
                    mail.setVisibility(View.INVISIBLE);
                    modMail.setVisibility(View.VISIBLE);
                    password.setVisibility(View.INVISIBLE);
                    modPass.setVisibility(View.VISIBLE);
                    modB.setVisibility(View.INVISIBLE);
                    buttonSave.setVisibility(View.VISIBLE);

                    modNome.setText(nome.getText());
                    modCognome.setText(cognome.getText());
                    modMail.setText(mail.getText());
                    modPass.setText(password.getText());
                }
            });
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(modNome.getText().length() > 3){
                        nome.setText(modNome.getText());
                    } else {
                        Snackbar.make(buttonSave, "Nome troppo corto!", Snackbar.LENGTH_SHORT).show();
                        flag1 = 0;
                    }
                    if(modCognome.getText().length() > 3){
                        cognome.setText(modCognome.getText());
                    } else {
                        Snackbar.make(buttonSave, "Cognome troppo corto!", Snackbar.LENGTH_SHORT).show();
                        flag1 = 0;
                    }
                    if(modMail.getText().length() > 7){
                        mail.setText(modMail.getText());

                    } else {
                        Snackbar.make(buttonSave, "Email troppo corta!", Snackbar.LENGTH_SHORT).show();
                        flag1 = 0;
                    }
                    if(modPass.getText().length() > 4){
                        password.setText(modPass.getText());

                    } else {
                        Snackbar.make(buttonSave, "Password troppo corta!", Snackbar.LENGTH_SHORT).show();
                        flag1 = 0;
                    }

                    if(flag1 == 1){
                        sqliteHelper.upUser(new User(id, modCognome.getText().toString(), modNome.getText().toString(), u.soul, modMail.getText().toString(), modPass.getText().toString()));

                        nome.setVisibility(View.VISIBLE);
                        modNome.setVisibility(View.INVISIBLE);
                        cognome.setVisibility(View.VISIBLE);
                        modCognome.setVisibility(View.INVISIBLE);
                        mail.setVisibility(View.VISIBLE);
                        modMail.setVisibility(View.INVISIBLE);
                        password.setVisibility(View.VISIBLE);
                        modPass.setVisibility(View.INVISIBLE);
                        modB.setVisibility(View.VISIBLE);
                        buttonSave.setVisibility(View.INVISIBLE);
                    } else { //flag == 0
                        nome.setText(u.userName);
                        cognome.setText(u.surname);
                        mail.setText(u.email);
                        password.setText(u.password);

                        nome.setVisibility(View.VISIBLE);
                        modNome.setVisibility(View.INVISIBLE);
                        cognome.setVisibility(View.VISIBLE);
                        modCognome.setVisibility(View.INVISIBLE);
                        mail.setVisibility(View.VISIBLE);
                        modMail.setVisibility(View.INVISIBLE);
                        password.setVisibility(View.VISIBLE);
                        modPass.setVisibility(View.INVISIBLE);
                        modB.setVisibility(View.VISIBLE);
                        buttonSave.setVisibility(View.INVISIBLE);
                    }

                }
            });

            flag = b.getBoolean("ultimoOrd", false);
            if(true){
                GregorianCalendar oggi = new GregorianCalendar();
                int giorno = oggi.get(Calendar.DAY_OF_MONTH);
                int mese = oggi.get(Calendar.MONTH);
                int anno = oggi.get(Calendar.YEAR);
                ultimoOrdine.setText("Acquisto del: "+giorno+"/"+mese+"/"+anno+" ");
                acquistaDiNuovo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bo = new Bundle();
                        bo.putBoolean("ultimoOrdine", true);
                        if(getActivity().getSupportFragmentManager().findFragmentByTag("carrello") == null){
                            CarrelloFragment carrelloFragment = new CarrelloFragment();
                            carrelloFragment.setArguments(bo);
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, carrelloFragment, "carrello").addToBackStack("carrello").commit();
                        } else{
                            CarrelloFragment carrelloFragment = (CarrelloFragment) getActivity().getSupportFragmentManager().findFragmentByTag("carrello");
                            carrelloFragment.setArguments(bo);
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, carrelloFragment, "carrello").addToBackStack("carrello").commit();
                        }
                    }
                });
            } else {
                ultimoOrdine.setText("Nessun ordine effettuato");
            }
        }
        return rootView;
    }
    private int flag1 = 1;
    private boolean trans = false;
    private boolean flag = false;
    private Button acquistaDiNuovo;
    private TextView ultimoOrdine;
    private SqliteHelper sqliteHelper;
    private TextView nome;
    private TextView cognome;
    private TextView mail;
    private TextView password;
    private Button modB;
    private View rootView;
    private EditText modNome;
    private EditText modCognome;
    private EditText modMail;
    private EditText modPass;
    private Button buttonSave;
}
