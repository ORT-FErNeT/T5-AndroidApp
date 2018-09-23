package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Perfil extends Activity {

    private ImageView perfil;
    private Button editarPerfilButton;
    private TextView datosDePerfil;
    private SQLiteDatabase db;
    private BaseDeDatos b;
    private ContentValues nuevoRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editarPerfilButton = (Button) findViewById(R.id.boton_editar_perfil_activity);

        perfil = (ImageView) findViewById(R.id.imagen_perfil);
        datosDePerfil = (TextView) findViewById(R.id.datos_perfil);
        perfil.setImageResource(R.drawable.avatar);
/*
        ///////se debe refactorizar todo esto para no repetir codigo/////////////////////////////////////////////////////////
        creamos la base de datos
        */
        b = new BaseDeDatos(this, "Ejemplo", null, 2);
        // la abrimos en modo escritura
        db = b.getWritableDatabase();



        //continuar aca para leer la base y lo concateno en un String para probar
        db = b.getReadableDatabase();
        String palabra = "";
        //utilizo un cursor para recorrer mi base de datos
        Cursor cursor = db.rawQuery("SELECT * FROM Ejemplo",null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    //estoy probando que se graban los ingrsos en la base
                    palabra += cursor.getString(cursor.getColumnIndex("nombre"));
                    palabra += "\n";
                    palabra += cursor.getString(cursor.getColumnIndex("apellido"));
                    palabra += "\n";
                    palabra += cursor.getString(cursor.getColumnIndex("edad"));
                    palabra += "\n";
                    palabra += cursor.getString(cursor.getColumnIndex("ubicacion"));
                    palabra += "\n";
                    palabra += cursor.getString(cursor.getColumnIndex("preferencias"));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {

        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        // mostramos en el TextView de prueba

        datosDePerfil.setText(palabra);
        /////fin zona de refactor///////////////////////
        editarPerfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditarPerfil.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
