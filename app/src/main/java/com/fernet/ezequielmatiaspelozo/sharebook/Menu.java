package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity {

    private Button miPerfil;
    private Button misLibros;
    private Button prestados;
    private Button librosDeseados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        miPerfil = (Button) findViewById(R.id.boton_mi_perfil);
        misLibros = (Button) findViewById(R.id.boton_mis_libros);
        prestados = (Button) findViewById(R.id.boton_prestados);
        librosDeseados = (Button) findViewById(R.id.boton_libros_deseados);



        misLibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), MisLibros.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
