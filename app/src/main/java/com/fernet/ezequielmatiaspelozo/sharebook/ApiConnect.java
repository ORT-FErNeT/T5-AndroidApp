package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ApiConnect extends Activity {


    private RequestQueue  mRequestQueue;
    private EditText busqueda;
    private Button botonBusqueda;
    private TextView ingreso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        busqueda = (EditText) findViewById(R.id.busqueda);
        botonBusqueda = (Button) findViewById(R.id.botonBusqueda);
        ingreso = (TextView) findViewById(R.id.ingreso);
        mRequestQueue = Volley.newRequestQueue(this);

       botonBusqueda.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               parseJson();
           }
       });

        }

        private void parseJson() {
        String url = "https://api.myjson.com/bins/hq93w";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ingreso.setText(" ");
                            JSONArray jsonArray = response.getJSONArray("employees");
                            JSONObject employee;
                            String firstName;
                            String email;
                            int age;
                            for (int i = 0; i < jsonArray.length(); i++){
                                employee = jsonArray.getJSONObject(i);
                                firstName = employee.getString("firstname");
                                email = employee.getString("mail");
                                age = employee.getInt("age");
                                ingreso.append(firstName + ", " + String.valueOf(age) + " , " + email + "\n\n" );

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
