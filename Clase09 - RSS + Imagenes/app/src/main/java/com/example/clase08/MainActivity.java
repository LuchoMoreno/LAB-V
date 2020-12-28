package com.example.clase08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int MENSAJE_TEXTO = 1;
    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Este this es la respuesta que va a llegar. el main evalua el mensaje
        // luego lo paso como parametro
        handler = new Handler(this);
        EjecutarHttp miHilo = new EjecutarHttp("https://www.clarin.com/rss/lo-ultimo/", handler, false);
        miHilo.start();


    }

    // Se ejecuta cuando hago el send.
    @Override
    public boolean handleMessage(@NonNull Message msg) {

        TextView tvRespuesta = findViewById(R.id.tvRespuesta);

        if (msg.arg1 == MENSAJE_TEXTO)
        {
            List<Noticia> noticias = (List<Noticia>) msg.obj;

            for (Noticia n : noticias)
            {
                Log.d("TITULO" , n.titulo);
            }

            tvRespuesta.setText(noticias.get(0).titulo);

            EjecutarHttp buscoImg = new EjecutarHttp(noticias.get(0).urlImg, handler, true);
            buscoImg.start();
        }

        else if (msg.arg1 == 3)
        {

            byte[] imgArray = (byte[]) msg.obj;
            ImageView imageView = this.findViewById(R.id.imagenTraida);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(imgArray, 0, imgArray.length));

        }

        return false;
    }
}
