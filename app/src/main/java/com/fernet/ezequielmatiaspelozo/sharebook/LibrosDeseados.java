package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LibrosDeseados extends Activity {
    private ListView misLibrosDeseados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_deseados);

        misLibrosDeseados = (ListView) findViewById(R.id.libros_deseados_lv);
        // Construct the data source
        ArrayList<Libro> libros = new ArrayList<Libro>();
// Create the adapter to convert the array to views
        final UserAdapter adapter = new UserAdapter(getApplicationContext(), libros);
// Attach the adapter to a ListView
        misLibrosDeseados.setAdapter(adapter);

    }
}
