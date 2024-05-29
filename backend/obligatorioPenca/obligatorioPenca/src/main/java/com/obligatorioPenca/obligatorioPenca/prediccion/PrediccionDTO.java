package com.obligatorioPenca.obligatorioPenca.prediccion;

import java.time.LocalDateTime;

public class PrediccionDTO {
    private Integer idEstudiante;

    private String nombreSeleccionLocal;
    private String nombreSeleccionVisitante;
    private LocalDateTime fechaPartido;
    private Integer golLocal;
    private Integer golVisitante;
    private Integer puntaje;

    public PrediccionDTO(Integer idEstudiante, String nombreSeleccionLocal, String nombreSeleccionVisitante, LocalDateTime fechaPartido, Integer golLocal, Integer golVisitante, Integer puntaje) {

        this.idEstudiante = idEstudiante;
        this.nombreSeleccionLocal = nombreSeleccionLocal;
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
        this.fechaPartido = fechaPartido;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
        this.puntaje = puntaje;
    }

    public String getNombreSeleccionLocal() {
        return nombreSeleccionLocal;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public void setNombreSeleccionLocal(String nombreSeleccionLocal) {
        this.nombreSeleccionLocal = nombreSeleccionLocal;
    }

    public String getNombreSeleccionVisitante() {
        return nombreSeleccionVisitante;
    }

    public void setNombreSeleccionVisitante(String nombreSeleccionVisitante) {
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
    }

    public LocalDateTime getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(LocalDateTime fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public Integer getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(Integer golLocal) {
        this.golLocal = golLocal;
    }

    public Integer getGolVisitante() {
        return golVisitante;
    }

    public Integer getIdEstudiante() {return idEstudiante;}

    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

}