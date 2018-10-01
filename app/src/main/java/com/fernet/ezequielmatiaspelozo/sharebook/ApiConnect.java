package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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


public class ApiConnect extends Activity {


    private RequestQueue  mRequestQueue;
    private EditText titulo;
    private Button botonBusqueda;
    private TextView ingreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        titulo = (EditText) findViewById(R.id.titulo);
        botonBusqueda = (Button) findViewById(R.id.botonBusqueda);
        ingreso = (TextView) findViewById(R.id.ingreso);
        mRequestQueue = Volley.newRequestQueue(this);

       botonBusqueda.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               searchBooks("1562518054");
           }
       });

        }

        private void searchBooks(String isbn) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
        url += isbn;
        ArrayList<Libro> libros new ArrayList<Libro>();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ingreso.setText(" ");
                            JSONArray booksArray = response.getJSONArray("items");
                            Libro libro;
                            for (int i = 0; i < booksArray.length(); i ++){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(request);
    }



}
