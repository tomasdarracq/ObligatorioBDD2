package com.obligatorioPenca.obligatorioPenca.partido;

import com.obligatorioPenca.obligatorioPenca.seleccion.Seleccion;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Partido {

    @EmbeddedId
    private PartidocompositeKey id;

    @ManyToOne
    @MapsId("seleccionlocalId")
    @JoinColumn(name = "seleccionlocal_id")
    private Seleccion seleccionlocal;

    @ManyToOne
    @MapsId("seleccionvisitanteId")
    @JoinColumn(name = "seleccionvisitante_id")
    private Seleccion seleccionvisitante;


    @Column(name = "goles_local")
    private int golesLocal;

    @Column(name = "goles_visitante")
    private int golesVisitante;

    // Constructors, getters, setters



    public Partido() {
    }

    public Partido(Seleccion seleccionlocal, Seleccion seleccionvisitante, Date fecha, int golesLocal, int golesVisitante) {
        this.seleccionlocal = seleccionlocal;
        this.seleccionvisitante = seleccionvisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        //this.id = new PartidocompositeKey(seleccionlocal.getId(), seleccionvisitante.getId());
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

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }


}
