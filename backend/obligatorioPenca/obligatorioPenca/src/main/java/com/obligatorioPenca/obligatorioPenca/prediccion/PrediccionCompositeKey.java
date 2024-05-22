package com.obligatorioPenca.obligatorioPenca.prediccion;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PrediccionCompositeKey implements Serializable {
    @Column(name = "idEstudiante")
    private Integer idEstudiante;

    @Column(name = "idPrediccion")
    private Integer idPrediccion;



    public PrediccionCompositeKey() {}

    public PrediccionCompositeKey(Integer idEstudiante, Integer idPrediccion) {
        this.idEstudiante = idEstudiante;
        this.idPrediccion = idPrediccion;

    }



    public Integer getIdPrediccion() {
        return idPrediccion;
    }

    public void setIdPrediccion(Integer idPrediccion) {
        this.idPrediccion = idPrediccion;
    }

    }

