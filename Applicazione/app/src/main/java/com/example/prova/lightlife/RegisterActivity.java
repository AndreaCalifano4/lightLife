package com.example.prova.lightlife;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    String soul;

    //Declaration EditTexts
    EditText editTextSurname;
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutSurname;
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutSoul;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Declaration RadioGroup
    RadioGroup radioSoul;

    //Declaration RadioButton
    RadioButton radioButtonCliente;
    RadioButton radioButtonNegoziante;

    //Declaration Button
    Button buttonRegister;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String surname = editTextSurname.getText().toString();
                    String UserName = editTextUserName.getText().toString();
                    //soul inizializzato in validate
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //Check in the database is there any user associated with  this email
                    if (!sqliteHelper.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        sqliteHelper.addUser(new User(null, surname, UserName, soul, Email, Password));
                        Snackbar.make(buttonRegister, "Utente creato con successo! ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {

                        //Email exists with email input provided so show error user already exist
                        Snackbar.make(buttonRegister, "Esite già un utente con la stessa email ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextSurname = (EditText) findViewById(R.id.surnameReg);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        radioSoul = findViewById(R.id.soul);
        radioButtonCliente = findViewById(R.id.cliente);
        radioButtonNegoziante = findViewById(R.id.negoziante);
        textInputLayoutSoul = findViewById(R.id.errorSoul);
        textInputLayoutSurname = (TextInputLayout) findViewById(R.id.surnameRegister);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String surname = editTextSurname.getText().toString();
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Inserisci un nome valido!");
        } else {
            if (UserName.length() > 2) {
                valid = true;
                textInputLayoutUserName.setError(null);
            } else {
                valid = false;
                textInputLayoutUserName.setError("Il nome è troppo corto!");
            }
        }

        if (surname.isEmpty()) {
            valid = false;
            textInputLayoutSurname.setError("Inserisci un cognome valido!");
        } else {
            if (surname.length() > 2) {
                valid = true;
                textInputLayoutSurname.setError(null);
            } else {
                valid = false;
                textInputLayoutSurname.setError("Il cognome è troppo corto!");
            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Inserisci una email valida!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Inserisci una password valida!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("La password è troppo corta!");
            }
        }

        if(radioSoul.getCheckedRadioButtonId() == -1){
            valid = false;
            textInputLayoutSoul.setError("Seleziona un'opzione!");
        }else{
            if(radioButtonCliente.isChecked()) {
                soul = radioButtonCliente.getText().toString();
                valid = true;
                textInputLayoutSoul.setError(null);
            }else{
                soul = radioButtonNegoziante.getText().toString();
                valid = true;
                textInputLayoutSoul.setError(null);
            }
        }

        return valid;
    }
}
