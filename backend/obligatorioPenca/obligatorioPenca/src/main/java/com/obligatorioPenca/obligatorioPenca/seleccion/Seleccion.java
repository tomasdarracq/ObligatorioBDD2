package com.obligatorioPenca.obligatorioPenca.seleccion;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Seleccion")
public class Seleccion {

    @Id
    @Column(name = "Nombre", nullable = false)
    private String nombre;

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

}
