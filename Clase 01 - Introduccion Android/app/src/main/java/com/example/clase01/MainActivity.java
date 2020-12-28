package com.example.clase01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = super.findViewById(R.id.texto);
        Button btn = super.findViewById(R.id.button);
        Button btn2 = super.findViewById(R.id.button2);

        MyListener listener = new MyListener(this, tv);
        btn.setOnClickListener(listener);
        btn2.setOnClickListener(listener);

    }
}
