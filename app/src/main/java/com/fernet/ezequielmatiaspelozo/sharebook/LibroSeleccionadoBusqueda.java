package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class LibroSeleccionadoBusqueda extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro_seleccionado_busqueda);

        Bundle b = this.getIntent().getExtras();

        final String idLibro;
        String tituloLibro;
        String urlLibro;

        TextView tv = findViewById(R.id.tvLibroSeleccionadoBusqueda);
        ImageView iv =  findViewById(R.id.ivLibroSeleccionadoBusqueda);

        Button btnSelecAgregarADeseados = findViewById(R.id.btnSelecAgregarADeseados);
        Button btnSelecAgregarAPrestados = findViewById(R.id.btnSelecAgregarAPrestados);

        try {

            idLibro = b.getString("idLibro");
            tituloLibro = b.getString("tituloLibro");
            urlLibro = b.getString("urlLibro");
            Log.e("TAG","OK mostrando id libro");
            Log.e("TAG",urlLibro);

            //fill tv and img
            tv.setText(tituloLibro);
            Picasso.get().load(urlLibro).into(iv);


        }   catch ( Exception e) {
            Log.e("ERROR",e.getMessage());
        }


        btnSelecAgregarADeseados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseManager dataBaseManager = new DataBaseManager(getApplicationContext());
                //dataBaseManager.saveWishedBook();

                Toast.makeText(getApplicationContext(), "El libro ha sido agregado a la lista de deseados!",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnSelecAgregarAPrestados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "El libro ha sido agregado a la lista de prestados!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }



}
