package com.example.practicaparcial;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class DialogGenericoListener implements DialogInterface.OnClickListener {


    private  int indiceItem;
    private  View view;
    private ProductoAdapter adapter;


    public DialogGenericoListener(int indiceItem, View view, ProductoAdapter adapter){
        this.indiceItem=indiceItem;
        this.view=view;
        this.adapter=adapter;
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {


        List<Producto> productos= MainActivity.obtenerLista();
        Producto productoAEditar=productos.get(this.indiceItem);
        EditText editTitulo =this.view.findViewById(R.id.inputNobre);
        String nuevoNombre=editTitulo.getText().toString();

        if(which==-1)
        {
            Log.d("PROBANDO  -1   !!!", productos.get(this.indiceItem).toString());
            productoAEditar.setNombre(nuevoNombre);
            this.adapter.setProductos(productos);
            this.adapter.notifyDataSetChanged();

        }


    }




}
