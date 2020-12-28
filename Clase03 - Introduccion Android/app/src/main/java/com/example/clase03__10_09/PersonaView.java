package com.example.clase03__10_09;

import android.widget.EditText;

public class PersonaView {

    MainActivity activity;
    PersonaModel modelo;

    public PersonaView(MainActivity activity, PersonaModel modelo){

        this.activity = activity;
        this.modelo = modelo;

    }

    public void cargarModelo(){

        EditText etNombre = activity.findViewById(R.id.textNombre);
        EditText etApellido = activity.findViewById(R.id.textApellido);

        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();


        modelo.setNombre(nombre);
        modelo.setApellido(apellido);

    }




}
