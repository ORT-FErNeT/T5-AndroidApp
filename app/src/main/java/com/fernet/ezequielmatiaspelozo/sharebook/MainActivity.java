package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inicio = (Button) findViewById(R.id.boton_menu);
        Button buscar = (Button) findViewById(R.id.boton_buscar);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i); // brings up the second activity
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first parameter is the context, second is the class of the activity to launch
                Intent i = new Intent(getApplicationContext(), ApiConnect.class);
                startActivity(i); // brings up the second activity
            }
        });
    }
}
