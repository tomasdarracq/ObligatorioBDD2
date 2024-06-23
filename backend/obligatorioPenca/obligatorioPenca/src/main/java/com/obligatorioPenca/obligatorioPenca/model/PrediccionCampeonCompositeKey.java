package com.obligatorioPenca.obligatorioPenca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PrediccionCampeonCompositeKey implements Serializable {
    @Column(name = "idEstudiante", insertable=false, updatable=false)
    private Integer idEstudiante;

    @Column(name = "nombreSeleccion", insertable=false, updatable=false)
    private String nombreSeleccion;

    public PrediccionCampeonCompositeKey(Integer idEstudiante, String nombreSeleccion) {
        this.idEstudiante = idEstudiante;
        this.nombreSeleccion = nombreSeleccion;
    }
    public PrediccionCampeonCompositeKey() {

    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreSeleccion() {
        return nombreSeleccion;
    }

    public void setNombreSeleccion(String nombreSeleccion) {
        this.nombreSeleccion = nombreSeleccion;
    }
}
