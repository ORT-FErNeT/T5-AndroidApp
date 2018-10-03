package com.fernet.ezequielmatiaspelozo.sharebook;

public class User {

    public String nombre;
    public String apellido;
    public String edad;
    public String ubicacion;
    public String preferencias;

    public User(){

    }

    public User(String nombre, String apellido, String edad, String ubicacion, String preferencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ubicacion = ubicacion;
        this.preferencias = preferencias;
    }
}
