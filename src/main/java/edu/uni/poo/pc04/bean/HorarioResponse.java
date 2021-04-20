package edu.uni.poo.pc04.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class HorarioResponse {
    private int id;
    private Date fecha;
    private Timestamp hora_inicio;
    private Timestamp hora_fin;
    private float costo;
    private String nombre_asesor;
    private String nombre_curso;

    public HorarioResponse(int id, Date fecha, Timestamp hora_inicio, Timestamp hora_fin, float costo, String nombre_asesor, String nombre_curso) {
        this.id = id;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.costo = costo;
        this.nombre_asesor = nombre_asesor;
        this.nombre_curso = nombre_curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Timestamp hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Timestamp getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Timestamp hora_fin) {
        this.hora_fin = hora_fin;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getNombre_asesor() {
        return nombre_asesor;
    }

    public void setNombre_asesor(String nombre_asesor) {
        this.nombre_asesor = nombre_asesor;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }
}
