package com.obligatorioPenca.obligatorioPenca.model;

import java.time.LocalDateTime;

public class PartidoDTO {
    private String seleccionLocalNombre;
    private String seleccionVisitanteNombre;
    private Integer golesLocal;
    private Integer golesVisitante;

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    private LocalDateTime fecha;




    public LocalDateTime getFecha() {
        return fecha;
    }

    public PartidoDTO(String seleccionLocalNombre, String seleccionVisitanteNombre, Integer golesLocal, Integer golesVisitante, LocalDateTime fecha) {
        this.seleccionLocalNombre = seleccionLocalNombre;
        this.seleccionVisitanteNombre = seleccionVisitanteNombre;
        this.golesLocal = golesLocal;
                //(golesLocal != null) ? golesLocal : 0;  // Manejo de null
        this.golesVisitante = golesVisitante;
                //(golesVisitante != null) ? golesVisitante : 0;  // Manejo de null
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



}
