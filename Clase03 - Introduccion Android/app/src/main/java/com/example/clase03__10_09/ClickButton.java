package com.example.clase03__10_09;

import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class ClickButton implements View.OnClickListener {

    private PersonaView view;
    private PersonaModel modelo;

    public ClickButton(PersonaView view, PersonaModel modelo){
        this.view = view;
        this.modelo = modelo;
    }

    @Override
    public void onClick(View v) {

        this.view.cargarModelo();
        Log.d("Persona ingresada:", modelo.toString());

    }
}
