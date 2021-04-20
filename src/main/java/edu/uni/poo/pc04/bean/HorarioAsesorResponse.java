package edu.uni.poo.pc04.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class HorarioAsesorResponse {
    private String nombre;
    private Date fecha;
    private Timestamp hora_inicio;
    private Timestamp hora_fin;
    private float costo;
    private String sala;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public HorarioAsesorResponse(String nombre, Date fecha, Timestamp hora_inicio, Timestamp hora_fin, float costo, String sala) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.costo = costo;
        this.sala = sala;
    }
}
