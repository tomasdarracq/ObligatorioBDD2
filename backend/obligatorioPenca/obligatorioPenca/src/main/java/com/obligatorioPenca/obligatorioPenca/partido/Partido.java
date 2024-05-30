package com.obligatorioPenca.obligatorioPenca.partido;

import com.obligatorioPenca.obligatorioPenca.seleccion.Seleccion;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Partido")
public class Partido {
    @EmbeddedId
    private PartidocompositeKey id;

    @ManyToOne
    @MapsId("nombreSeleccionLocal")
    @JoinColumn(name = "nombreSeleccionLocal", referencedColumnName = "nombre")
    private Seleccion seleccionlocal;

    @ManyToOne
    @MapsId("nombreSeleccionVisitante")
    @JoinColumn(name = "nombreSeleccionVisitante", referencedColumnName = "nombre")
    private Seleccion seleccionvisitante;

    @Column(name = "golLocal")
    private Integer golLocal;

    @Column(name = "golVisitante")
    private Integer golVisitante;

    // Constructors, getters, setters

    public Partido() {}

    public Partido(Seleccion seleccionlocal, Seleccion seleccionvisitante, LocalDateTime fecha, Integer golLocal, Integer golVisitante) {
        this.seleccionlocal = seleccionlocal;
        this.seleccionvisitante = seleccionvisitante;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
        this.id = new PartidocompositeKey(seleccionlocal.getNombre(), seleccionvisitante.getNombre(), fecha);
    }



    public PartidocompositeKey getId() {
        return id;
    }

    public void setId(PartidocompositeKey id) {
        this.id = id;
    }

    public Seleccion getSeleccionlocal() {
        return seleccionlocal;
    }

    public void setSeleccionlocal(Seleccion seleccionlocal) {
        this.seleccionlocal = seleccionlocal;
    }

    public Seleccion getSeleccionvisitante() {
        return seleccionvisitante;
    }

    public void setSeleccionvisitante(Seleccion seleccionvisitante) {
        this.seleccionvisitante = seleccionvisitante;
    }

    public Integer getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(Integer golLocal) {
        this.golLocal = golLocal;
    }

    public Integer getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(id, partido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
