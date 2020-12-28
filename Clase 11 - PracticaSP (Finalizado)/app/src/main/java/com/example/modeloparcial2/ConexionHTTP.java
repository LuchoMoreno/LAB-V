package com.example.modeloparcial2;


// ESTA CLASE LO QUE HACE, ES CREAR LA CONEXION HTTP. NO ES UN HILO

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConexionHTTP {


    public String obtenerRespuesta (String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            if (200 == urlConnection.getResponseCode())
            {
                InputStream is = urlConnection.getInputStream();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int lenght = 0;

                while((lenght = is.read(buffer)) != -1) // Hay que guardar en un buffer de bytes, y a medida que lee, guardando en objeto.
                {
                    baos.write(buffer, 0, lenght);
                }

                is.close();

                Log.d("Respuesta server", baos.toString());

                return baos.toString(); // RETURN SI SALE BIEN
            }

            else
            {
                throw new RuntimeException("Error" + urlConnection.getResponseCode());
            }

        }

        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null; // RETURN SI SALE MAL, IGUAL NUNCA LLEGA ACÁ

    }


}
