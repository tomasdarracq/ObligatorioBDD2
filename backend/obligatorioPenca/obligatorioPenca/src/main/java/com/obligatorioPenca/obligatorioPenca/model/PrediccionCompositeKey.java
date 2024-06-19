package com.obligatorioPenca.obligatorioPenca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PrediccionCompositeKey implements Serializable {


    @Column(name = "idEstudiante", insertable=false, updatable=false)
    private Integer idEstudiante;

    @Column(name = "nombreSeleccionLocal", insertable=false, updatable=false)
    private String nombreSeleccionLocal;

    @Column(name = "nombreSeleccionVisitante", insertable=false, updatable=false)
    private String nombreSeleccionVisitante;

    @Column(name = "fecha", insertable=false, updatable=false)
    private LocalDateTime fecha;

    public PrediccionCompositeKey() {}

    public PrediccionCompositeKey(Integer idEstudiante, String nombreSeleccionLocal, String nombreSeleccionVisitante, LocalDateTime fecha) {
        this.idEstudiante = idEstudiante;
        this.nombreSeleccionLocal = nombreSeleccionLocal;
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
        this.fecha = fecha;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreSeleccionLocal() {
        return nombreSeleccionLocal;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
