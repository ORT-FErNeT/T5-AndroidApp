package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarPerfil extends Activity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private EditText ubicacion;
    private EditText preferencias;
    private Button editar;
    private DataBaseManager dbmn;
    private User user;


    private TextView prueba;
    private Button actualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);


        Context context = EditarPerfil.this;
        SharedPreferences perfilSettings = context.getSharedPreferences("Perfil", Context.MODE_PRIVATE);
        String  nombreValue = perfilSettings.getString("nombre", "");
        String  apellidoValue = perfilSettings.getString("apellido", "");
        String  edadValue = perfilSettings.getString("edad", "");
        String  ubicacionValue = perfilSettings.getString("ubicacion", "");
        String  prefsValue = perfilSettings.getString("preferencias", "");

        nombre = (EditText) findViewById(R.id.nombre_edit);
        apellido = (EditText) findViewById(R.id.apellido_edit);
        edad = (EditText) findViewById(R.id.edad_edit);
        ubicacion = (EditText) findViewById(R.id.ubicacion_edit);
        preferencias = (EditText) findViewById(R.id.preferencia_edit);

        nombre.setText(nombreValue);
        apellido.setText(apellidoValue);
        edad.setText(edadValue);
        ubicacion.setText(ubicacionValue);
        preferencias.setText(prefsValue);





        editar = (Button) findViewById(R.id.boton_editar_perfil);
        dbmn = new DataBaseManager(this);



        //accion del boton de editar
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "El campo Nombre y Apellido son obligatorios",
                            Toast.LENGTH_LONG).show();
                } else {

                    // Activity Context
                    Context context =EditarPerfil.this; // or getActivity(); in case of Fragments

                    SharedPreferences mSettings = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = mSettings.edit();
                    //recupero data de Shared preference
                    String  usserName = mSettings.getString("username", "missing");
                    String password = mSettings.getString("pasword", "missing");

                    //agrego
                    String textNombre = nombre.getText().toString();
                    String textApellido = apellido.getText().toString();
                    String textEdad = edad.getText().toString();
                    String textUbicacion = ubicacion.getText().toString();
                    String textPreferencia = preferencias.getText().toString();
                    //inicializo mi usuario
                    user = new User(textNombre,textApellido,textEdad, textUbicacion,textPreferencia, usserName, password);
                    //guardo mi usuario
                    dbmn.inputData(user);
                    Toast.makeText(getApplicationContext(), "Los datos fueron guardado con exito!",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),Perfil.class);
                    startActivity(i);
                }



            }
        });


    }
}
