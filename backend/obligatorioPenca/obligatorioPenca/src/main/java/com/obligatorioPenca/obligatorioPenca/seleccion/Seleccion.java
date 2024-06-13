package com.obligatorioPenca.obligatorioPenca.seleccion;

import jakarta.persistence.*;

@Entity
@Table(name = "Seleccion")
public class Seleccion {


    @Id
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    @Column(name = "estado")
    private String estado;

    public Seleccion() {
    }

    public Seleccion(String nombre) {
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
