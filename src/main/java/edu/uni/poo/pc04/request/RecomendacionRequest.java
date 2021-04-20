package edu.uni.poo.pc04.request;

public class RecomendacionRequest {
    private int id_asesoria;
    private String comentario;

    public RecomendacionRequest(int id_asesoria, String comentario) {
        this.id_asesoria = id_asesoria;
        this.comentario = comentario;
    }

    public int getId_asesoria() {
        return id_asesoria;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
