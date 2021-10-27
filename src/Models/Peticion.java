package Models;

import java.util.Date;

public class Peticion {
    private String obraSocial;
    private Date fechaCarga;
    private Date fechaEntrega;
    private boolean finalizada;

    public String getObraSocial() {
        return obraSocial;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Peticion(String obraSocial, Date fechaCarga, Date fechaEntrega, boolean finalizada) {
        this.obraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.fechaEntrega = fechaEntrega;
        this.finalizada = finalizada;
    }
}
