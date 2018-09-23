package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditarPerfil extends Activity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private EditText ubicacion;
    private EditText preferencias;
    private Button editar;
    private SQLiteDatabase db;
    private BaseDeDatos b;
    private ContentValues nuevoRegistro;

    private TextView prueba;
    private Button actualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        nombre = (EditText) findViewById(R.id.nombre_edit);
        apellido = (EditText) findViewById(R.id.apellido_edit);
        edad = (EditText) findViewById(R.id.edad_edit);
        ubicacion = (EditText) findViewById(R.id.ubicacion_edit);
        preferencias = (EditText) findViewById(R.id.preferencia_edit);
        editar = (Button) findViewById(R.id.boton_editar_perfil);
        //para probar la base de datos
        prueba = (TextView) findViewById(R.id.prueba_base_de_datos);
        actualizar = (Button) findViewById(R.id.actualizar_perfil);


        // creamos la base de datos
        b = new BaseDeDatos(this, "Ejemplo", null, 2);
        // la abrimos en modo escritura
        db = b.getWritableDatabase();
        //accion del boton de editar
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // limpiamos los TextView
                db = b.getWritableDatabase();
                db.beginTransaction();
                try {
                    // Order of deletions is important when foreign key relationships exist.
                    db.delete("Ejemplo", null, null);

                    db.setTransactionSuccessful();
                } catch (Exception e) {

                } finally {
                    db.endTransaction();
                }
                //agrego
                String textNombre = nombre.getText().toString();
                String textApellido = apellido.getText().toString();
                String textEdad = edad.getText().toString();
                String textUbicacion = ubicacion.getText().toString();
                String textPreferencia = preferencias.getText().toString();

                // inicializo ContentValue
                nuevoRegistro = new ContentValues();
                // insertamos los datos en el ContentValues
                nuevoRegistro.put("nombre", textNombre);
               nuevoRegistro.put("apellido", textApellido);
                nuevoRegistro.put("edad", textEdad);
                nuevoRegistro.put("ubicacion", textUbicacion);
                nuevoRegistro.put("preferencias", textPreferencia);
                // insertamos en la base
                db.insert("Ejemplo", null, nuevoRegistro);
                nuevoRegistro.clear();

            }
        });


        //muestro los datos actualizados
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                prueba.setText(palabra);

            }
        });

    }
}
