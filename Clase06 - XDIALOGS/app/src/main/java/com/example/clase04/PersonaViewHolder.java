package com.example.clase04;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView tvNombre;

    public TextView tvApellido;

    public int position = 0; // Esto es para tener una posición

    public MainActivity mainActivity;


    public PersonaViewHolder(MainActivity mainActivity, @NonNull View itemView) {
        super(itemView);

        tvNombre = itemView.findViewById(R.id.nombre);
        tvApellido = itemView.findViewById(R.id.apellido);

        this.mainActivity = mainActivity;

        itemView.setOnClickListener(this); // IMPORTANTE.

    }

    @Override
    public void onClick(View v) {this.mainActivity.llamarPorTelefono(this.position); }
}
