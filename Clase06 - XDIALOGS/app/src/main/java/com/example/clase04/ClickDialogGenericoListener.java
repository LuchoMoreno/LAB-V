package com.example.clase04;

import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;

public class ClickDialogGenericoListener implements DialogInterface.OnClickListener {
    @Override
    public void onClick(DialogInterface dialog, int which) {


        switch (which)
        {
            case Dialog.BUTTON_POSITIVE:
                Log.d("Texto", "Se hizo click en POSITIVO");
                break;

            case Dialog.BUTTON_NEUTRAL:
                Log.d("Texto", "Se hizo click en NEUTRAL");
                break;

            case Dialog.BUTTON_NEGATIVE:
                Log.d("Texto", "Se hizo click en NEGATIVO");
                break;
        }



    }
}
