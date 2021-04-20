package edu.uni.poo.pc04.bean;


import java.sql.Date;
import java.sql.Timestamp;

public class AlumnosResponse {
    private String nombre;
    private String apellido;
    private int telefono;
    private String curso;
    private int id_asesoria;

    public AlumnosResponse(String nombre, String apellido, int telefono, String curso, int id_asesoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.curso = curso;
        this.id_asesoria = id_asesoria;
    }

    public AlumnosResponse(int anInt, Date date, Timestamp timestamp, Timestamp timestamp1, float aFloat, String string, String string1) {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }
}
