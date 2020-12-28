package com.example.clase04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle  = super.getIntent().getExtras();

        TextView tvNombre = findViewById(R.id.nombre);
        TextView tvTel = findViewById(R.id.telefono);

        tvNombre.setText(bundle.getString("Nombre"));

        // ACA CRASHEA.
        tvTel.setText(Integer.valueOf(bundle.getInt("Telefono" + "")).toString());

        Button btn = super.findViewById(R.id.btnActivity2);
        btn.setOnClickListener(new LlamarTelefonoClick(this, bundle.getInt("Telefono")));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
