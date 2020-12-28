package com.example.clase08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int MENSAJE_TEXTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        // Este this es la respuesta que va a llegar. el main evalua el mensaje
        // luego lo paso como parametro
        Handler handler = new Handler(this);


        EjecutarHttp miHilo = new EjecutarHttp("https://restcountries.eu/rest/v2/region/europe", handler);
        miHilo.start();


    }

    // Se ejecuta cuando hago el send.
    @Override
    public boolean handleMessage(@NonNull Message msg) {

        TextView tvRespuesta = findViewById(R.id.tvRespuesta);

        if (msg.arg1 == MENSAJE_TEXTO)
        {
            tvRespuesta.setText(msg.obj.toString());
        }

        else if (msg.arg1 == 2)
        {
            List<String> lista = (List<String>) msg.obj;
            TextView tvRespuesta2 = findViewById(R.id.tvRespuesta);
            tvRespuesta2.setText(lista.get(2));

        }


        return false;
    }
}
