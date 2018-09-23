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

public class Menu extends Activity {

    private Button miPerfil;
    private Button misLibros;
    private Button prestados;
    private Button librosDeseados;
    private ImageView perfil;
    private TextView textoPerfil;
    // para refactor
    private SQLiteDatabase db;
    private BaseDeDatos b;
    private ContentValues nuevoRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        miPerfil = (Button) findViewById(R.id.boton_mi_perfil);
        misLibros = (Button) findViewById(R.id.boton_mis_libros);
        prestados = (Button) findViewById(R.id.boton_prestados);
        textoPerfil = (TextView) findViewById(R.id.texto_perfil_menu);
        librosDeseados = (Button) findViewById(R.id.boton_libros_deseados);

        perfil = (ImageView) findViewById(R.id.foto_menu);
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

        textoPerfil.setText(palabra);

    ///fin zona de refactor///////////////////////////////////////////////////////////

        misLibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), MisLibros.class);
                startActivity(i); // brings up the second activity
            }
        });

        miPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent  i = new Intent(getApplicationContext(), Perfil.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
