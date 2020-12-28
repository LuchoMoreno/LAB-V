package com.example.clase04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    // INSTANCIAS GENERALES:
    private PersonaAdapter personaAdapter;


    // NUEVA LISTA ARRAYLIST
    private static final List<Persona> personas=new ArrayList<Persona>();


    // ESTO ES PARA ENVIAR LA LISTA AL NEW ACTIVITY
    public static  List<Persona> obtenerLista()
    {
        return  personas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas.add(new Persona("Lucho", "Moreno"));
        personas.add(new Persona("Natalia", "Samaniego"));
        personas.add(new Persona("Julieta", "Sdrubolini"));

        personaAdapter = new PersonaAdapter(this, personas);

        // Recupero el recycler.
        RecyclerView rc = super.findViewById(R.id.recycler);

        // Le digo quien es su adapter.
        rc.setAdapter(personaAdapter);

        // Le digo como mostrar la información:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // Lo seteo.
        rc.setLayoutManager(linearLayoutManager);



        // BARRA DE TAREAS.

        // con esto pongo visible el action bar de volver.
        ActionBar actionBar = super.getSupportActionBar();

        // CON ESTO SETEO EL TITULO.
        actionBar.setTitle("Contactos");

        // CON ESTO LO HAGO VISIBLE.
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    // ON RESUME.
    @Override
    protected void onResume() {
        super.onResume();
        personaAdapter.setPersonas(personas);
        this.personaAdapter.notifyDataSetChanged();
    }


    public void llamarPorTelefono(int posicionPersona)
    {
        Persona p = this.personas.get(posicionPersona);
        Toast toast = Toast.makeText(this, "Llamando a: " + p.getNombre(), Toast.LENGTH_SHORT);
        toast.show();
        Log.d("Llamando a", p.getNombre());
    }



    // CLASE 05 -----------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // CON ESTO SOBREESCRIBO EL MENU QUE YO TENGO, Y LE PONGO EL NUEVO MENU QUE YO CREÉ
        getMenuInflater().inflate(R.menu.menu, menu); // El primer parametro es nuestro menu XML, el segundo es el parametro de la función

        // CON ESTO MANEJO LA LUPITA.
        MenuItem menuItem = menu.findItem(R.id.opSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.op1:
                Log.d("Click", "Se hizo click en la opcion 1");

                DialogGenerico dialog = new DialogGenerico();
                dialog.show(getSupportFragmentManager(), "Etiqueta de OP1");

                break;

            case R.id.op2:
                Log.d("Click", "Se hizo click en la opcion 2");

                Intent intent = new Intent(this,AddcontactActivity.class);
                startActivity(intent);

                break;


            case R.id.op3:
                Log.d("Click", "Se hizo click en la opcion 3");

                Intent intent2 = new Intent(this, Main2Activity.class);

                intent2.putExtra("Nombre", "Lucho");
                intent2.putExtra("Telefono", 123456);
                startActivity(intent2);

                break;

            case android.R.id.home:
                super.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // ESTO ES PARA LA BUSQUEDA DE OBJETOS.

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("onQueryTextSubmit", query);

        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("onQueryTextChange", newText);


        List<Persona> auxList = new ArrayList<Persona>();

        for(Persona auxPersona : this.personas)
        {

            if(auxPersona.getApellido().toUpperCase().startsWith(newText.toUpperCase()))
            {
                auxList.add(auxPersona);
                Log.d("PRUEBA", "ESTOY ACA HDP COINCIDO");
            }
        }

        personaAdapter.setPersonas(auxList);
        personaAdapter.notifyDataSetChanged();

        return false;
    }
}
