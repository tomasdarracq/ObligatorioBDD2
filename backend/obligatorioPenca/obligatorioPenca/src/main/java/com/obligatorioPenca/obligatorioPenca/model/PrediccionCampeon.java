package com.obligatorioPenca.obligatorioPenca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Estudiante_Elige_Seleccion")
public class PrediccionCampeon {

    @EmbeddedId
    private PrediccionCampeonCompositeKey id;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumns({
            @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante"),
    })
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("nombreSeleccion")
    @JoinColumns({
            @JoinColumn(name = "nombreSeleccion", referencedColumnName = "nombre"),
    })
    private Seleccion seleccion;
    @Column(name = "eleccion")
    private String eleccion;

    public PrediccionCampeon(Estudiante estudiante, Seleccion seleccion, String eleccion) {
        this.id = new PrediccionCampeonCompositeKey(estudiante.getIdEstudiante(),seleccion.getNombre());
        this.estudiante = estudiante;
        this.seleccion = seleccion;
        this.eleccion = eleccion;
    }
    public PrediccionCampeon() {

    }

    public void setId(PrediccionCampeonCompositeKey id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }

    public PrediccionCampeonCompositeKey getId() {
        return id;
    }


}
