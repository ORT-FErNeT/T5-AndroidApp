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
    }
}
