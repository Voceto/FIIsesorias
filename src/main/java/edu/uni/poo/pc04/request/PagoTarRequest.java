package edu.uni.poo.pc04.request;

public class PagoTarRequest {
    private int id_tar;
    private double monto;

    public int getId_tar() {
        return id_tar;
    }

    public void setId_tar(int id_tar) {
        this.id_tar = id_tar;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
