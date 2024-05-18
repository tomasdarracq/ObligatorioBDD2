package com.obligatorioPenca.obligatorioPenca.partido;

import java.util.Date;

public class Partido {
    private long id;
    private long idseleccionlocal;
    private long idseleccionvisitante;
    private int goles_local;
    private Date fecha;
    private int goles_vistante;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Partido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdseleccionlocal() {
        return idseleccionlocal;
    }

    public void setIdseleccionlocal(long idseleccionlocal) {
        this.idseleccionlocal = idseleccionlocal;
    }

    public long getIdseleccionvisitante() {
        return idseleccionvisitante;
    }

    public void setIdseleccionvisitante(long idseleccionvisitante) {
        this.idseleccionvisitante = idseleccionvisitante;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_vistante() {
        return goles_vistante;
    }

    public void setGoles_vistante(int goles_vistante) {
        this.goles_vistante = goles_vistante;
    }
}
