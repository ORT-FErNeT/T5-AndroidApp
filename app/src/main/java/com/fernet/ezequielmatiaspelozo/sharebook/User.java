package com.fernet.ezequielmatiaspelozo.sharebook;

public class User {

    public String nombre;
    public String apellido;
    public String edad;
    public String ubicacion;
    public String preferencias;
    public String usserName;
    public String password;

    public User(){

    }

    public User(String nombre, String apellido, String edad, String ubicacion, String preferencias, String usserName, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ubicacion = ubicacion;
        this.preferencias = preferencias;
        this.usserName = usserName;
        this.password = password;
    }
}
