package com.example.clase04;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGenerico extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        // EL getActivity es la activity que genere este objeto. Va a guardarse como referencia.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle("Titulo");

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.alta_persona, null);
        builder.setView(v);


        ClickDialogGenericoListener listenerNuevo = new ClickDialogGenericoListener();
        builder.setNeutralButton("Neutral", listenerNuevo);
        builder.setPositiveButton("Positive", listenerNuevo);
        builder.setNegativeButton("Negativo", listenerNuevo);

        return builder.create();

    }
}
