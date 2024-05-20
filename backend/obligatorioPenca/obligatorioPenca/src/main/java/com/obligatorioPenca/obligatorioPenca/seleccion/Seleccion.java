package com.obligatorioPenca.obligatorioPenca.seleccion;

import jakarta.persistence.*;

@Entity
@Table(name = "Seleccion")
public class Seleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeleccion")
    private int idSeleccion;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public Seleccion() {
    }

    public Seleccion(String nombre) {
        this.nombre = nombre;
    }

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
