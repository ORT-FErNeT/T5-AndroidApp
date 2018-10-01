package com.fernet.ezequielmatiaspelozo.sharebook;

import android.graphics.drawable.Drawable;
import android.widget.Button;


public class Libro {

    public  String titulo;
    public String imagen;

    public String getTitulo(){
        return this.titulo;
    }
    public String getImagen(){
        return this.imagen;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }

}
