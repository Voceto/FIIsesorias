package edu.uni.poo.pc04.request;

public class TarjetaRequest {

    private int id_tipo_tar;
    private String id_usuario;
    private String propietario;
    private int nro_tar;
    private String cvc;
    private int caducidad;



    public int getId_tipo_tar() {
        return id_tipo_tar;
    }

    public void setId_tipo_tar(int id_tipo_tar) {
        this.id_tipo_tar = id_tipo_tar;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getNro_tar() {
        return nro_tar;
    }

    public void setNro_tar(int nro_tar) {
        this.nro_tar = nro_tar;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public int getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
    }
}
