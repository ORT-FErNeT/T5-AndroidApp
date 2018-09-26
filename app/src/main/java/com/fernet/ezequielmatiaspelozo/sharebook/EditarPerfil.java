package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
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
    private DataBaseManager dbmn;


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
        dbmn = new DataBaseManager(this);

        //para probar la base de datos
        prueba = (TextView) findViewById(R.id.prueba_base_de_datos);
        actualizar = (Button) findViewById(R.id.actualizar_perfil);



        //accion del boton de editar
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //agrego
                String textNombre = nombre.getText().toString();
                String textApellido = apellido.getText().toString();
                String textEdad = edad.getText().toString();
                String textUbicacion = ubicacion.getText().toString();
                String textPreferencia = preferencias.getText().toString();

               dbmn.inputData(textNombre,textApellido,textEdad,textUbicacion,textPreferencia);

            }
        });


        //muestro los datos actualizados
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String palabra = dbmn.returnData();
                prueba.setText(palabra);

            }
        });

    }
}
