package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;


public class ApiConnect extends Activity {
    private RequestQueue  mRequestQueue;
    private Button botonBusqueda;
    private ArrayList<Libro> libros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        botonBusqueda = (Button) findViewById(R.id.botonBusqueda);
        mRequestQueue = Volley.newRequestQueue(this);

        botonBusqueda.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                EditText titulo = (EditText) findViewById(R.id.titulo);
                EditText autor = (EditText) findViewById(R.id.autor);

                String mTitulo = titulo.getText().toString();
                String mAutor = autor.getText().toString();
                if(mTitulo.isEmpty() == false || mAutor.isEmpty() ==false ){
                    searchBooks(mTitulo,mAutor);
                }


            }
        });

    }

    private void searchBooks(String titulo,String autor) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=";
        if (!autor.isEmpty() ) {
            url += "inauthor=" + autor + "&";
        }
        if (!titulo.isEmpty()){
            url += "intitle=" +titulo + "&";
        }
        Log.e("TEST",url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray booksArray = response.getJSONArray("items");
                            String titulo;
                            JSONObject imagenes;
                            String imagenThumb;
                            Libro libro;
                            JSONObject libroGoogleEntero;
                            JSONObject libroGoogleVolume;
                            for (int i = 0; i < booksArray.length(); i ++) {
                                libroGoogleEntero = booksArray.getJSONObject(i);
                                libroGoogleVolume = libroGoogleEntero.getJSONObject("volumeInfo");
                                titulo = libroGoogleVolume.getString("title");
                                libro = new Libro();
                                libro.setId(libroGoogleEntero.getString("id"));
                                try {
                                    imagenes = libroGoogleVolume.getJSONObject("imageLinks");
                                    imagenThumb = imagenes.getString("thumbnail");
                                    libro.setImagen(imagenThumb);
                                } catch (JSONException e) {
                                    libro.setImagenDefault();
                                }
                                libro.setTitulo(titulo);
                                setLibro(libro);
                            }
                            fillBooksSearch();

                        } catch (JSONException e) {
                            Log.e("ERROR",e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Log.e("ERROR", error.getMessage());
                    }
                });
        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(request);
    }
    private void setLibro(Libro libro){
        this.libros.add(libro);
    }

    private void fillBooksSearch(){
        LinearLayout librosContainer = (LinearLayout) findViewById(R.id.LibrosContainerResult);
        String idLibro;
        String tituloLibro;
        String urlLibro;
        TextView tv;
        ImageView img;




        for (int i = 0; i < this.libros.size(); i++){


            urlLibro = libros.get(i).getImagen();
            idLibro = libros.get(i).getId();
            tituloLibro = libros.get(i).getTitulo();

            final Bundle b = new Bundle();

            b.putString("urlLibro",urlLibro);
            b.putString("idLibro",idLibro);
            b.putString("tituloLibro",tituloLibro);



            tv = new TextView(this);
            tv.setText(tituloLibro);
            librosContainer.addView(tv);
            img = new ImageView(this);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ApiConnect.this,LibroSeleccionadoBusqueda.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            });
            Picasso.get().load(urlLibro).into(img);
            librosContainer.addView(img);
        }
    }
}
