package com.obligatorioPenca.obligatorioPenca.partido;

import java.time.LocalDate;
import java.util.Date;

public class PartidoDTO {
    private String seleccionLocalNombre;
    private String seleccionVisitanteNombre;
    private int golesLocal;
    private int golesVisitante;
    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSeleccionLocalNombre() {
        return seleccionLocalNombre;
    }

    public void setSeleccionLocalNombre(String seleccionLocalNombre) {
        this.seleccionLocalNombre = seleccionLocalNombre;
    }

    public String getSeleccionVisitanteNombre() {
        return seleccionVisitanteNombre;
    }

    public void setSeleccionVisitanteNombre(String seleccionVisitanteNombre) {
        this.seleccionVisitanteNombre = seleccionVisitanteNombre;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
}
