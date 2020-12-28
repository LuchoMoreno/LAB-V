package com.example.clase04;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LlamarTelefonoClick implements View.OnClickListener {


    private Main2Activity main2Activity;
    private int telefono;


    public LlamarTelefonoClick(Main2Activity main2Activity, int telefono){
        this.main2Activity = main2Activity;
        this.telefono = telefono;
    }



    @Override
    public void onClick(View v) {

        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + telefono));

        // HAGO UN IF PARA VERIFICAR QUE EL USUARIO ACEPTÓ LOS SERVICIOS.
        if (ContextCompat.checkSelfPermission(main2Activity.getApplicationContext(), Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED)
        {
            main2Activity.startActivity(callIntent);

        }else
        {
            ActivityCompat.requestPermissions(main2Activity,
                    new String[] {Manifest.permission.CALL_PHONE},
                    0);
        }


    }
}
