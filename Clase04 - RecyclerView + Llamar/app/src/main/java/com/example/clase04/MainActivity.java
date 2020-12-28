package com.example.clase04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Persona> personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas.add(new Persona("Lucho01", "Moreno01"));
        personas.add(new Persona("Lucho02", "Moreno02"));
        personas.add(new Persona("Lucho03", "Moreno03"));
        personas.add(new Persona("Lucho04", "Moreno04"));
        personas.add(new Persona("Lucho05", "Moreno05"));
        personas.add(new Persona("Lucho06", "Moreno06"));
        personas.add(new Persona("Lucho07", "Moreno07"));
        personas.add(new Persona("Lucho08", "Moreno08"));
        personas.add(new Persona("Lucho09", "Moreno09"));
        personas.add(new Persona("Lucho10", "Moreno10"));

        PersonaAdapter personaAdapter = new PersonaAdapter(this, personas);

        // Recupero el recycler.
        RecyclerView rc = super.findViewById(R.id.recycler);

        // Le digo quien es su adapter.
        rc.setAdapter(personaAdapter);


        // Le digo como mostrar la información:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Lo seteo.
        rc.setLayoutManager(linearLayoutManager);

    }


    public void llamarPorTelefono(int posicionPersona)
    {
        Persona p = this.personas.get(posicionPersona);
        Toast toast = Toast.makeText(this, "Llamando a: " + p.getNombre(), Toast.LENGTH_SHORT);
        toast.show();
        Log.d("Llamando a", p.getNombre());
    }


}
