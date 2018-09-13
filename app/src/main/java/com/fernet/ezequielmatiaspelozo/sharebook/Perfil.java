package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Perfil extends Activity {

    private ImageView perfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        perfil = (ImageView) findViewById(R.id.imagen_perfil);
        perfil.setImageResource(R.drawable.avatar);
    }
}
