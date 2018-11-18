package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Menu extends Activity {

    private Button miPerfil;
    private Button misLibros;
    private Button prestados;
    private Button librosDeseados;
    private Button cambiarContrasenia;
    private ImageView perfil;
    private TextView textoPerfil;
    private DataBaseManager dbmn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        miPerfil = (Button) findViewById(R.id.boton_mi_perfil);
        misLibros = (Button) findViewById(R.id.boton_mis_libros);
        prestados = (Button) findViewById(R.id.boton_prestados);
        textoPerfil = (TextView) findViewById(R.id.texto_perfil_menu);
        librosDeseados = (Button) findViewById(R.id.boton_libros_deseados);
        cambiarContrasenia = (Button) findViewById(R.id.boton_cambiar_contrasenia);

        dbmn = new DataBaseManager(this);

        perfil = (ImageView) findViewById(R.id.foto_menu);
        perfil.setImageResource(R.drawable.avatar);

        //cargo los datos de la BD en mi perfil del menu
        String palabra = dbmn.returnData();
        textoPerfil.setText(palabra);
        //voy a mis libros
        misLibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), MisLibros.class);
                startActivity(i); // brings up the second activity
            }
        });
        //voy a mi perfil
        miPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), Perfil.class);
                startActivity(i); // brings up the second activity
            }
        });
        //voy a libros prestados
        prestados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), LibrosPrestados.class);
                startActivity(i); // brings up the second activity
            }
        });
        //voy a mi libros deseados
        librosDeseados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), LibrosDeseados.class);
                startActivity(i); // brings up the second activity
            }
        });
        //voy a cambiar contrasenia
        cambiarContrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), CambiarContrasenia.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
