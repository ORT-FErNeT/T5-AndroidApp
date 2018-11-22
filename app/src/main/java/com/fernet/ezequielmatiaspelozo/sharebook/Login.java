package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

    private EditText nombre;
    private EditText clave;
    private Button ingreso;
    private TextView intentos;
    private String usserName = "";
    private String password = "";
    private int counter = 5;
    public static final String defaultPasword = "1234";
    public static final String defaultUsserName =  "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = (EditText)findViewById(R.id.login_name);
        clave =  (EditText)findViewById(R.id.login_password);
        ingreso =(Button) findViewById(R.id.login_button);
        intentos=(TextView)findViewById(R.id.login_incorrect);

        intentos.setText( "numero de intentos restantes: " + String.valueOf(counter));

        //Uso SharedPreferences para guardar el nombre y clave

        // Activity Context
        Context context = Login.this; // or getActivity(); in case of Fragments

        SharedPreferences mSettings = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mSettings.edit();

        //editor.putString("username",defaultUsserName);
        //editor.putString("pasword",defaultPasword);
        //editor.apply();

        //recupero data de Shared preference
        usserName = mSettings.getString("username", "missing");
        password = mSettings.getString("pasword", "missing");

        //si no hay password y ussername los seteo por default
        if (usserName.equals("missing")) {
            setUsserName(defaultUsserName);
        }
        if (password.equals("missing")) {
            setPassword(defaultPasword);
        }

        ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(nombre.getText().toString(),clave.getText().toString());
            }
        });

    }

    private void setUsserName(String usserName ){
        this.usserName = usserName;
    }

    private void setPassword(String password){
        this.password = password;
    }

    private void validate(String userNAme, String userPassword){

        if(userNAme.equals(this.usserName) && userPassword.equals(this.password) ) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            Toast.makeText(getApplicationContext(), "Clave correcta!",
                    Toast.LENGTH_LONG).show();
            startActivity(i); // brings up the second activity
        }else {
            counter--;
            intentos.setText("numero de intentos restantes: " + String.valueOf(counter));
            if(counter == 0){
                ingreso.setEnabled(false);
            }
        }

    }
}



