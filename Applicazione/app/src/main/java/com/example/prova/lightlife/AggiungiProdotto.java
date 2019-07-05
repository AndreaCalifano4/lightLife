package com.example.prova.lightlife;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class AggiungiProdotto extends AppCompatActivity {
    private EditText editTextTitolo;
    private EditText editTextPrezzo;
    private EditText editTextDescrizione;
    private ImageView imgView;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aggiungi_prodotto);
        this.editTextTitolo=findViewById(R.id.EditTextTitolo);
        this.editTextPrezzo=findViewById(R.id.EditTextPrezzo);
        this.editTextDescrizione=findViewById(R.id.EditTextDescrizione);
        this.imgView=findViewById(R.id.ImgView);
        this.bitmap=null;
    }

    public void confermaAggiuntaProdotto(View view) {
        String titolo, descrizione;
        double prezzo;
        Drawable immagine;
        titolo=this.editTextTitolo.getText().toString();
        prezzo=Double.parseDouble(this.editTextPrezzo.getText().toString());
        descrizione=this.editTextDescrizione.getText().toString();
        Prodotto prodotto=new Prodotto(titolo, prezzo, descrizione, this.bitmap, getResources().getDrawable(R.drawable.delete));
        ListaProdotti.addProdotto(prodotto);
        AlertDialog.Builder abs=new AlertDialog.Builder(AggiungiProdotto.this);
        abs.setMessage("Prodotto aggiunto correttamente");
        abs.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog=abs.create();
        alertDialog.show();
    }

    public void azzeraForm(View view) {
        this.editTextTitolo.setText("");
        this.editTextDescrizione.setText("");
        this.editTextPrezzo.setText("");
        this.imgView.setImageBitmap(null);
    }

    public void aggiungiFoto(View view) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
            Uri contentURI = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                this.imgView.setImageBitmap(bitmap);
                this.bitmap=bitmap;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(AggiungiProdotto.this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void homePage(View v){
        Intent login = new Intent(getApplicationContext(), HomePageNegoziante.class);
        startActivity(login);
    }

    public void logOut(View v){
        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(login);
        finish();
    }

    public void zoomImage(View view) {
        BitmapImageCorrente.addBitmap(this.bitmap);
        Intent intent= new Intent(getApplicationContext(), ZoomFoto.class);
        startActivity(intent);
    }
}
