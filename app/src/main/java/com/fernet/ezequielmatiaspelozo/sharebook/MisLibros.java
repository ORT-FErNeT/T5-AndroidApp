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

        // Add item to adapter
        Libro miLibro1 = new Libro("prueba1",R.drawable.readyplayerone);
        Libro miLibro2 = new Libro("prueba2",R.drawable.tolkiencomunidad);
        Libro miLibro3 = new Libro("prueba3",R.drawable.readyplayerone);
        Libro miLibro4 = new Libro("prueba4",R.drawable.tolkiencomunidad);
        Libro miLibro5 = new Libro("prueba5",R.drawable.readyplayerone);
        Libro miLibro6 = new Libro("prueba6",R.drawable.tolkiencomunidad);
        Libro miLibro7 = new Libro("prueba7",R.drawable.readyplayerone);

        adapter.add(miLibro1);
        adapter.add(miLibro2);
        adapter.add(miLibro3);
        adapter.add(miLibro4);
        adapter.add(miLibro5);
        adapter.add(miLibro6);
        adapter.add(miLibro7);

    }
}
