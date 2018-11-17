package com.fernet.ezequielmatiaspelozo.sharebook;

public class User {

    private String nombre;
    private String apellido;
    private String edad;
    private String ubicacion;
    private String preferencias;

    public String getUsserName() {
        return usserName;
    }

    public void setUsserName(String usserName) {
        this.usserName = usserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String usserName;
    private String password;

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
