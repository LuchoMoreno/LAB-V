package com.example.clase01;

import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MyListener implements View.OnClickListener {


    MainActivity activity;
    TextView tv;

    public MyListener(MainActivity activity, TextView tv){
        this.activity = activity;
        this.tv = tv;
    }

    @Override
    public void onClick(View v) {

    if (v.getId() == R.id.button)
    {
        EditText ed = activity.findViewById(R.id.edit);
        tv.setText(ed.getText());
    }
    else
    {
        tv.setText("Chau");
    }


        //Por consola
        // Log.d("Click","Se hizo click en el boton saludar" + ed.getText());

    }
}
