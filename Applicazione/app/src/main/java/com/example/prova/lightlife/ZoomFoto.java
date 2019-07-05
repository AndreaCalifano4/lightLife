package com.example.prova.lightlife;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ZoomFoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_image);
        ImageView imageView=findViewById(R.id.ImageViewZoom);
        ArrayList<Bitmap> lista=BitmapImageCorrente.getLista();
        Bitmap bitmap=lista.get(0);
        imageView.setImageBitmap(bitmap);
    }
}
