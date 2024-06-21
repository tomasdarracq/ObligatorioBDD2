package com.obligatorioPenca.obligatorioPenca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @Column(name = "idEstudiante")
    private Integer idEstudiante;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "puntajeTotal")
    private Integer puntajeTotal;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(Integer idEstudiante, String nombre, String email, String contrasena, String carrera) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.carrera = carrera;
        this.puntajeTotal = 0;
    }

    public Estudiante() {

    }
}
