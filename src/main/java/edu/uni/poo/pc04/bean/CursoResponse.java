package edu.uni.poo.pc04.bean;

public class CursoResponse {
    private int ord;
    private String nombre;
    private int cantidad;

    public CursoResponse(int ord, String nombre, int cantidad) {
        this.ord = ord;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
