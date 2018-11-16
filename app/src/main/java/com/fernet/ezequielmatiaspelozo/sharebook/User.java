package com.fernet.ezequielmatiaspelozo.sharebook;

public class User {

    private String nombre;
    private String apellido;
    private String edad;
    private String ubicacion;
    private String preferencias;

    public User(){

    }

    public User(String nombre, String apellido, String edad, String ubicacion, String preferencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ubicacion = ubicacion;
        this.preferencias = preferencias;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
