package edu.uni.poo.pc04.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class AsesoriaResponse {
    private int id;
    private String nombre_curso;
    private String nombre_asesor;
    private Timestamp hora_inicio;
    private Timestamp hora_fin;
    private Date fecha;
    private String sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AsesoriaResponse(int id, String nombre_curso, String nombre_asesor, Timestamp hora_inicio, Timestamp hora_fin, Date fecha, String sala) {
        this.id = id;
        this.nombre_curso = nombre_curso;
        this.nombre_asesor = nombre_asesor;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
        this.sala = sala;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getNombre_asesor() {
        return nombre_asesor;
    }

    public void setNombre_asesor(String nombre_asesor) {
        this.nombre_asesor = nombre_asesor;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
