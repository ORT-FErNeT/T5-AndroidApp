package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Perfil extends Activity {

    private ImageView perfil;
    private Button editarPerfilButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editarPerfilButton = (Button) findViewById(R.id.boton_editar_perfil);

        perfil = (ImageView) findViewById(R.id.imagen_perfil);
        perfil.setImageResource(R.drawable.avatar);
    }
}
