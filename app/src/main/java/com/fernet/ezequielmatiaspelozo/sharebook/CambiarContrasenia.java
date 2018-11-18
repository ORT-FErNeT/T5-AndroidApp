package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CambiarContrasenia extends Activity {

    private EditText nombre;
    private EditText clave;
    private Button ingreso;
    private TextView correcto;

    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasenia);

        nombre = (EditText) findViewById(R.id.cambiar_contrasenia_name);
        clave = (EditText) findViewById(R.id.cambiar_contrasenia_password);
        ingreso = (Button) findViewById(R.id.cambiar_contrasenia_button);
        correcto = (TextView) findViewById(R.id.cambiar_contrasenia_correct);



        ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nombre.getText().toString();
                password = clave.getText().toString();
                //Uso SharedPreferences para guardar el nombre y clave

                // Activity Context
                Context context = CambiarContrasenia.this; // or getActivity(); in case of Fragments

                SharedPreferences mSettings = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = mSettings.edit();

                if(name.equals("")||password.equals("")) {

                    //-----------------Key-------Value--------
                    editor.putString( "username","admin");
                    editor.putString( "pasword","1234");
                    editor.apply();


                } else {

                    //-----------------Key-------Value--------
                    editor.putString( "username",name);
                    editor.putString( "pasword",password);
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "La clave fue cambiada con exito!",
                            Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}
