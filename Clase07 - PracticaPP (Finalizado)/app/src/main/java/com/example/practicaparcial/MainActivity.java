package com.example.practicaparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    public static  List<Producto> obtenerLista(){
        return  productos;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        productos.add(new Producto("Tomate", 2, 10));
        productos.add(new Producto("Agua", 5, 100));
        productos.add(new Producto("Pan", 10, 200));


        productoAdapter = new ProductoAdapter(this, productos);

        RecyclerView rc = super.findViewById(R.id.recycler);

        rc.setAdapter(productoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Lo seteo.
        rc.setLayoutManager(linearLayoutManager);


    }


    public void obtenerProducto(int posicionProducto, int idBoton)
    {

        List<Producto> productos = MainActivity.obtenerLista();
        Producto producto;

        switch (idBoton)
        {
            case R.id.btnMas:

                producto= productos.get(posicionProducto);
                producto.setCantidad( producto.getCantidad()+1);
                productos.set(posicionProducto,producto);

                break;
            case R.id.btnMenos:
                producto= productos.get(posicionProducto);
                producto.setCantidad( producto.getCantidad()-1);
                productos.set(posicionProducto,producto);
                Log.d("PRODUCTO", productos.get(posicionProducto).toString());
                break;

            case R.id.btnEditar:
                DialogGenerico dialog = new DialogGenerico(productoAdapter,"Administrador de productos","Ingresa el nuevo nombre",true,false,true, posicionProducto);
                dialog.show(getSupportFragmentManager(),"onOptionItemSelected desde aca");
                break;

        }

        productoAdapter.setProductos(productos);
        productoAdapter.notifyDataSetChanged();

    }

}
