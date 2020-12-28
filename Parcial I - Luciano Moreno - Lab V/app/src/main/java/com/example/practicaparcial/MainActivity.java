package com.example.practicaparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // NUEVA LISTA ARRAYLIST
    private static final List<Producto> productos = new ArrayList<Producto>();


    // INSTANCIAS GENERALES:
    private ProductoAdapter productoAdapter;


    public static  List<Producto> obtenerLista()
    {
        return  productos;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        productos.add(new Producto("Tomate", 2, 10));
        productos.add(new Producto("Agua", 5, 100));
        productos.add(new Producto("Salchicha", 2, 55));
        productos.add(new Producto("Pan", 10, 200));
        productos.add(new Producto("Papas", 10, 40 ));
        productos.add(new Producto("Miel", 2, 22 ));
        productos.add(new Producto("Cereal", 3, 50 ));
        productos.add(new Producto("Vino", 15, 220 ));
        productos.add(new Producto("Azucar", 5, 500 ));
        productos.add(new Producto("Te", 2, 20 ));
        productos.add(new Producto("Carne", 10, 300 ));



        productoAdapter = new ProductoAdapter(this, productos);

        RecyclerView rc = super.findViewById(R.id.recycler);

        rc.setAdapter(productoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Lo seteo.
        rc.setLayoutManager(linearLayoutManager);


    }


    public void seleccionarProducto(int posicionProducto)
    {
        Producto p = this.productos.get(posicionProducto);

        Intent intent = new Intent(this,EditarActivity.class);

        intent.putExtra("posicionProducto", posicionProducto);

        Toast toast = Toast.makeText(this, "Producto seleccionado: " + p.getNombre(), Toast.LENGTH_SHORT);
        toast.show();

        startActivity(intent);

    }


    @Override
    protected void onResume() {
        super.onResume();
        this.productoAdapter.notifyDataSetChanged();
    }




}
