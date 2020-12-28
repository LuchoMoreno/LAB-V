package com.example.modeloparcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Handler.Callback {

    Handler handler = null;
    TextView userGeneral;
    TextView passwordGeneral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);


        SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        String u = preferences.getString("user", null);
        String p = preferences.getString("password", null);

        if (u != null && p !=null)
        {
            Intent i = new Intent(this, UsuarioCorrectoActivity.class);
            startActivity(i);
        }


    }

    @Override
    public void onClick(View v) {

        TextView tvUser = findViewById(R.id.userName);
        TextView tvPass = findViewById(R.id.userPassword);

        this.userGeneral = tvUser;
        this.passwordGeneral = tvPass;

        Log.d("Nombre y password: ", tvUser.getText().toString() + tvPass.getText().toString() );

        handler = new Handler(this);

        EjecutarHTTP miHilo = new EjecutarHTTP("http://192.168.0.14:3000/loginUsuario?usr=" + tvUser.getText().toString() + "&pass=" + tvPass.getText().toString(), handler);

        miHilo.start();

    }

        @Override
        public boolean handleMessage(@NonNull Message msg) {

            if ("true".equals(msg.obj) && msg.arg1 == 1)
            {

                SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user", this.userGeneral.toString());
                editor.putString("password", this.passwordGeneral.toString());

                editor.commit();

                Intent i = new Intent(this, UsuarioCorrectoActivity.class);
                startActivity(i);

            }


             return false;
        }




    }
