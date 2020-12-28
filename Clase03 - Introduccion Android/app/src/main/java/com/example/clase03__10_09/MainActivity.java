package com.example.clase03__10_09;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonaModel personaModel = new PersonaModel();

        PersonaView personaView = new PersonaView(this, personaModel);

        ClickButton clickButton = new ClickButton(personaView, personaModel);

        Button btn = super.findViewById(R.id.btn);

        btn.setOnClickListener(clickButton);

    }
}
