package com.obligatorioPenca.obligatorioPenca.partido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PartidoDTO {
    private String seleccionLocalNombre;
    private String seleccionVisitanteNombre;
    private int golesLocal;
    private int golesVisitante;
    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public PartidoDTO(String seleccionLocalNombre, String seleccionVisitanteNombre, int golesLocal, int golesVisitante, LocalDateTime fecha) {
        this.seleccionLocalNombre = seleccionLocalNombre;
        this.seleccionVisitanteNombre = seleccionVisitanteNombre;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.fecha = fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
// Getters y Setters

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
