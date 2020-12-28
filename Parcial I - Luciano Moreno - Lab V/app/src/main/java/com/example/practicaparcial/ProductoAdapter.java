package com.example.practicaparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {


    // LISTA PRIVADA DE PRODUCTOS.
    private List<Producto> productos;


    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


    MainActivity activity;


    public ProductoAdapter(MainActivity activity, List<Producto> productos){
        this.activity = activity;
        this.productos = productos;
    }




    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(activity, v);
        return productoViewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {

        holder.tvNombre.setText(productos.get(position).getNombre());
        holder.tvCantidad.setText(Integer.valueOf(productos.get(position).getCantidad()).toString());
        holder.tvPrecioUnitario.setText(Integer.valueOf(productos.get(position).getPrecioUnitario()).toString());
        holder.indice=position;
    }



    @Override
    public int getItemCount() { return this.productos.size(); }
}
