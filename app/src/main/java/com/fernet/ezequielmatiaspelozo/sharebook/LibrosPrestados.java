package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LibrosPrestados extends Activity {

    private ListView misLibrosPrestados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_prestados);

        misLibrosPrestados = (ListView) findViewById(R.id.libros_prestados_lv);


        // Construct the data source
        ArrayList<Libro> libros = new ArrayList<Libro>();
// Create the adapter to convert the array to views
        final UserAdapter adapter = new UserAdapter(getApplicationContext(), libros);
// Attach the adapter to a ListView
        misLibrosPrestados.setAdapter(adapter);
        Libro libro1 = new Libro();
        Libro libro2 = new Libro();
        Libro libro3 = new Libro();

        libro1.setTitulo("en construccion");
        libro1.setImagenDePrueba(R.drawable.contruccion1);
        libro2.setTitulo("Tolkien");
        libro2.setImagenDePrueba(R.drawable.tolkiencomunidad);
        libro3.setTitulo("en construccion");
        libro3.setImagenDePrueba(R.drawable.construccion3);
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
