package com.fernet.ezequielmatiaspelozo.sharebook;

import android.graphics.drawable.Drawable;
import android.widget.Button;


public class Libro {
    private String titulo;
    private String imagen;
    private String id;

    public String getId() { return id; }
    public String getTitulo() {
        return titulo;
    }
    public String getImagen() {
        return imagen;
    }

    public void setTitulo(String mTitulo) {
        this.titulo = mTitulo;
    }

    public void setImagen(String mImagen) {
        this.imagen = mImagen;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setImagenDefault() {
        this.imagen = "http://www.ort.edu.ar/img/LogoOrtArgWeb2017.jpg";
    }
}
