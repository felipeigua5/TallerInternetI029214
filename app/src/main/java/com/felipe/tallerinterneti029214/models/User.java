package com.felipe.tallerinterneti029214.models;

/**
 * Created by User on 17/04/2018.
 */

public class User {

    private String codigo;
    private String nombre;
    private String edad;
    private String correo;
    private String pass;

    public User(){}

    public User(String codigo, String nombre, String edad, String correo, String pass) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.pass = pass;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
