package com.fernet.ezequielmatiaspelozo.sharebook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Libros extends Activity {

    private RequestQueue mRequestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        mRequestQueue = Volley.newRequestQueue(this);
    }
}
