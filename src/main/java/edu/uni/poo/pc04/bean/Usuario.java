package edu.uni.poo.pc04.bean;

public class Usuario {
    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private String nombre_universidad;
    private String email;
    private String username;

    public Usuario( String nombre, String apellido, int dni, int telefono, String nombre_universidad, String email, String username) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.nombre_universidad = nombre_universidad;
        this.email = email;
        this.username = username;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
