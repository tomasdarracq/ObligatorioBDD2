package com.obligatorioPenca.obligatorioPenca.seleccion;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Seleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "seleccionlocal")
    private Set<Partido> partidosComoLocal = new HashSet<>();

    @OneToMany(mappedBy = "seleccionvisitante")
    private Set<Partido> partidosComoVisitante = new HashSet<>();

    // Constructors, getters, setters

    public Seleccion() {
    }

    public Seleccion(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Partido> getPartidosComoLocal() {
        return partidosComoLocal;
    }

    public void setPartidosComoLocal(Set<Partido> partidosComoLocal) {
        this.partidosComoLocal = partidosComoLocal;
    }

    public Set<Partido> getPartidosComoVisitante() {
        return partidosComoVisitante;
    }

    public void setPartidosComoVisitante(Set<Partido> partidosComoVisitante) {
        this.partidosComoVisitante = partidosComoVisitante;
    }
}
