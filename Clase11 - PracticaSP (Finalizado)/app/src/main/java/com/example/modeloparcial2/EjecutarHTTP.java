package com.example.modeloparcial2;

// CLASE HILO QUE EJECUTA LA CONEXIONHTTP.

import android.os.Message;

import org.json.JSONException;

import android.os.Handler;

public class EjecutarHTTP extends Thread {

    private String link;
    Handler handler;

    public EjecutarHTTP(String link, Handler handler)
    {
        this.link = link;
        this.handler = handler;
    }

    @Override
    public void run() {

        ConexionHTTP conexion = new ConexionHTTP();
        String s = conexion.obtenerRespuesta(link);

        Message mensaje = new Message();

        try
        {
            mensaje.obj = s.toString();
        }

        catch (Exception e) {

            e.printStackTrace();
        }

        mensaje.arg1 = 1;

        this.handler.sendMessage(mensaje);

    }


}
