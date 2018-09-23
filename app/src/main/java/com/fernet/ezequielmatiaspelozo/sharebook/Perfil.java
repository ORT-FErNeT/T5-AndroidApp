package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Perfil extends Activity {

    private ImageView perfil;
    private Button editarPerfilButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editarPerfilButton = (Button) findViewById(R.id.boton_editar_perfil_activity);

        perfil = (ImageView) findViewById(R.id.imagen_perfil);
        perfil.setImageResource(R.drawable.avatar);

        editarPerfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditarPerfil.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
