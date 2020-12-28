package com.example.clase08;

import android.nfc.cardemulation.HostApduService;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class EjecutarHttp extends Thread {


    private String link;
    Handler handler;

    public EjecutarHttp(String link, Handler handler){
        this.link = link;
        this.handler = handler;
    }



    @Override
    public void run() {

        ConexionHTTP conexion = new ConexionHTTP();
        String json = conexion.obtenerRespuesta(link);

        Message mensaje = new Message();

        try
        {
            mensaje.obj = generarListaString(json);
        }

        catch (JSONException e)
        {
            e.printStackTrace();
        }

        mensaje.arg1 = 2; // ESTO HAY QUE CAMBIARLOOOOOOOOOOOOOOOOOOOOOOOOOOOO

        this.handler.sendMessage(mensaje);

        // https://restcountries.eu/rest/v2/name/argentina
        // https://www.breakingbadapi.com/api/characters
    }


    private List<String> generarListaString (String json) throws JSONException {
        List<String> paises = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i<jsonArray.length(); i++)
        {
            JSONObject object = jsonArray.getJSONObject(i);
            paises.add(object.getString("name"));
        }

        return paises;

    }


}
