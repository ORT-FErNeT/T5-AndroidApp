package com.fernet.ezequielmatiaspelozo.sharebook;

public class UsuarioLibro {

    public UsuarioLibro() {

    }

    public UsuarioLibro(String idLibro, String userName, String estado) {
        this.idLibro = idLibro;
        this.userName = userName;
        this.estado = estado;
    }
    private String idLibro;
    private String userName;
    private String estado;

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.estado + this.idLibro + this.userName;
    }
}
