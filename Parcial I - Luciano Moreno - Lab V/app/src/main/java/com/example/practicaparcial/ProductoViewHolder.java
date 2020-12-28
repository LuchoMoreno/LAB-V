package com.example.practicaparcial;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView tvNombre;
    public TextView tvCantidad;
    public TextView tvPrecioUnitario;
    public int indice = 0;


    public Button btnRestar;
    public Button btnSumar;
    public Button btnEditar;



    public MainActivity mainActivity;



    public ProductoViewHolder(MainActivity mainActivity, @NonNull View itemView) {
        super(itemView);

        tvNombre = itemView.findViewById(R.id.nombre);
        tvCantidad = itemView.findViewById(R.id.cantidad);
        tvPrecioUnitario = itemView.findViewById(R.id.precio);


        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        this.mainActivity.seleccionarProducto(this.indice);

    }
}
