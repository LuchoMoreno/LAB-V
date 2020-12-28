package com.example.clase08;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.Objects;

public class Noticia {

    public String titulo;
    public String descripcion;
    public String link;
    public String urlImg;

    public byte[] img;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noticia noticia = (Noticia) o;
        return titulo.equals(noticia.titulo) &&
                descripcion.equals(noticia.descripcion) &&
                link.equals(noticia.link) &&
                urlImg.equals(noticia.urlImg) &&
                Arrays.equals(img, noticia.img);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        int result = Objects.hash(titulo, descripcion, link, urlImg);
        result = 31 * result + Arrays.hashCode(img);
        return result;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", link='" + link + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", img=" + Arrays.toString(img) +
                '}';
    }
}
