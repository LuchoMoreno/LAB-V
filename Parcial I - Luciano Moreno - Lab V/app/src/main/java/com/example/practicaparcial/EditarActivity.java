package com.example.practicaparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {

    private ProductoAdapter adapter;
    private List<Producto> listaProductos;

    int posicionDelProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        listaProductos = MainActivity.obtenerLista();

        Bundle bandle=super.getIntent().getExtras();
        posicionDelProducto = bandle.getInt("posicionProducto");

        Button btnEditar = this.findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(this);


        // BARRA DE TAREAS.
        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle("Modificar");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onClick(View v) {


        Producto productoAEditar=listaProductos.get(posicionDelProducto);

        EditText nombre = this.findViewById(R.id.inputName);
        EditText precio = this.findViewById(R.id.inputCantidad);
        EditText cantidad = this.findViewById(R.id.inputPrecio);

        String nuevoNombre= nombre.getText().toString();
        String nuevoPrecio= precio.getText().toString();
        String nuevaCantidad= cantidad.getText().toString();

        productoAEditar.setNombre(nuevoNombre);
        productoAEditar.setPrecioUnitario(Integer.valueOf(nuevoPrecio).intValue());
        productoAEditar.setCantidad(Integer.valueOf(nuevaCantidad).intValue());

        this.finish();

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == 16908332)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
