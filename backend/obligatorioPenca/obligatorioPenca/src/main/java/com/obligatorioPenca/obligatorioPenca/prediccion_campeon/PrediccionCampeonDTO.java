package com.obligatorioPenca.obligatorioPenca.prediccion_campeon;

public class PrediccionCampeonDTO {
    private Integer idEstudiante;

    private String nombreSeleccion;
    private String eleccion;

    public PrediccionCampeonDTO(Integer idEstudiante, String nombreSeleccion, String eleccion) {
        this.idEstudiante = idEstudiante;
        this.nombreSeleccion = nombreSeleccion;
        this.eleccion = eleccion;
    }
    public PrediccionCampeonDTO() {
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

    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }
}
