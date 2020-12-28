package com.example.clase04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {

    // LISTA PRIVADA DE PERSONAS.
    private List<Persona> personas;

    // GETTER.
    public List<Persona> getPersonas()
    {
        return personas;
    }

    // SETTER
    public void setPersonas(List<Persona> personas)
    {
        this.personas = personas;
    }


    MainActivity activity;


    public PersonaAdapter(MainActivity activity, List<Persona> personas){
        this.activity = activity;
        this.personas = personas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Edto levanta el item layout, lo recorre linea a linea, y por cada tag de apertura genera
        // el objeto java que corresponde.

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(activity, v);
        return personaViewHolder;
    }


    // Aca cargamos la información de la persona.
    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {

        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvApellido.setText(personas.get(position).getApellido());
        holder.position = position;

    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}