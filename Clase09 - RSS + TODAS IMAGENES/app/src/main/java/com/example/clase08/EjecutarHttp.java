package com.example.clase08;

import android.nfc.cardemulation.HostApduService;
import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class EjecutarHttp extends Thread {


    private String link;
    Handler handler;
    boolean esImagen;

    public EjecutarHttp(String link, Handler handler, boolean esImagen){
        this.link = link;
        this.handler = handler;
        this.esImagen = esImagen;
    }



    @Override
    public void run() {

        ConexionHTTP conexion = new ConexionHTTP();


        if (esImagen)
        {

            byte[] imagen = conexion.obtenerRespuestaImagen(link);
            Message mensaje = new Message();
            mensaje.obj = imagen;
            mensaje.arg1 = 3;
            this.handler.sendMessage(mensaje);
        }

        else
        {

            String xml = conexion.obtenerRespuesta(link);
            Message mensaje = new Message();
            mensaje.obj = parserNoticiaByXML(xml);
            mensaje.arg1 = 1;
            this.handler.sendMessage(mensaje);
        }



    }


    private List<Noticia> parserNoticiaByXML ( String xml)
    {
        List<Noticia> noticias = new ArrayList<>();

        XmlPullParser parser = Xml.newPullParser();

        Noticia n = null;

        try
        {
            parser.setInput(new StringReader(xml));
            int evento = parser.getEventType();


            while (evento != XmlPullParser.END_DOCUMENT)
            {

                if (evento == XmlPullParser.START_TAG)
                {
                    String nombreTag = parser.getName();

                    if ("title".equals(nombreTag) && n != null)
                    {
                        n.titulo = parser.nextText();
                    }

                    else if ("item".equals(nombreTag))
                    {
                        n = new Noticia();
                    }
                    else if ("enclosure".equals(nombreTag))
                    {
                        n.urlImg = parser.getAttributeValue(null, "url");
                    }

                }else if (evento == XmlPullParser.END_TAG)
                {
                    String nombreTag = parser.getName();

                    if ("item".equals(nombreTag))
                    {
                        noticias.add(n);
                    }
                }

                evento = parser.next();

            }


        } catch (XmlPullParserException | IOException e)
        {
            e.printStackTrace();
        }

        return noticias;
    }







}
