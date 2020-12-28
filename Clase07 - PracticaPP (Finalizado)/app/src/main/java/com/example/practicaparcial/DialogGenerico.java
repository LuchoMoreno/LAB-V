package com.example.practicaparcial;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGenerico extends DialogFragment {


    private  String mensaje;
    private  String titulo;

    private Boolean neutral;
    private Boolean negative;
    private Boolean positive;
    private int indiceItem;

    ProductoAdapter adapter;


    public DialogGenerico( ProductoAdapter adapter,String titulo, String mensaje,Boolean positive,Boolean neutral,Boolean negative,int indiceItem){
        this.titulo=titulo;
        this.mensaje=mensaje;
        this.positive=positive;
        this.neutral=neutral;
        this.negative=negative;
        this.indiceItem=indiceItem;
        this.adapter=adapter;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());//obtiene la activity que genere este objeto
        builder.setTitle(this.titulo);
        builder.setMessage(this.mensaje);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.cambiar_nombre,null);
        builder.setView(view);

        DialogGenericoListener listener=new DialogGenericoListener(this.indiceItem,view,this.adapter);


        if(this.neutral){
            builder.setNeutralButton("--",listener);
        }
        if(this.positive){
            builder.setPositiveButton("Guardar",listener);
        }
        if(this.negative){
            builder.setNegativeButton("Cancelar",listener);
        }
        return  builder.create();
    }
}
