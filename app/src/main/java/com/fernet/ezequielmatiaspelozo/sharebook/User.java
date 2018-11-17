package com.fernet.ezequielmatiaspelozo.sharebook;

public class User {

    private String nombre;
    private String apellido;
    private String edad;
    private String ubicacion;
    private String preferencias;
    private String usserName;
    private String password;

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
