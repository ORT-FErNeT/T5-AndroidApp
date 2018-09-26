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
    private DataBaseManager dbmn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editarPerfilButton = (Button) findViewById(R.id.boton_editar_perfil_activity);

        perfil = (ImageView) findViewById(R.id.imagen_perfil);
        datosDePerfil = (TextView) findViewById(R.id.datos_perfil);
        perfil.setImageResource(R.drawable.avatar);
        dbmn = new DataBaseManager(this);


        //cargo datos de perfil desde mi DB
        String palabra = dbmn.returnData();

        datosDePerfil.setText(palabra);

        editarPerfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditarPerfil.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
