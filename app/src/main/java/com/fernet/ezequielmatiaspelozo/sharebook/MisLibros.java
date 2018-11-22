package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MisLibros extends Activity {

    private ListView misLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_libros);

        misLibros = (ListView) findViewById(R.id.mi_lista_de_libros);
        // Construct the data source
        ArrayList<Libro> libros = new ArrayList<Libro>();
// Create the adapter to convert the array to views
        final UserAdapter adapter = new UserAdapter(getApplicationContext(), libros);
// Attach the adapter to a ListView
        misLibros.setAdapter(adapter);



        Libro libro1 = new Libro();
        Libro libro2 = new Libro();
        Libro libro3 = new Libro();

        libro1.setTitulo("en construccion");
        libro1.setImagenDePrueba(R.drawable.contruccion1);
        libro2.setTitulo("Ready");
        libro2.setImagenDePrueba(R.drawable.readyplayerone);
        libro3.setTitulo("Working");
        libro3.setImagenDePrueba(R.drawable.proximamente);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
    }
}
