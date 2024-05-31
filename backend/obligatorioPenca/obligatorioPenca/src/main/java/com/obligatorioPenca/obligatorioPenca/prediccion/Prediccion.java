package com.obligatorioPenca.obligatorioPenca.prediccion;

import com.obligatorioPenca.obligatorioPenca.estudiante.Estudiante;
import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import com.obligatorioPenca.obligatorioPenca.seleccion.Seleccion;
import jakarta.persistence.IdClass;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
//@IdClass(PrediccionCompositeKey.class)
@Table(name = "Estudiante_Realiza_Prediccion")
public class Prediccion {



    @EmbeddedId
    private PrediccionCompositeKey id;

    @ManyToOne
    //@MapsId("partidoId") // Nombre del atributo en PrediccionCompositeKey
    @JoinColumns({
            @JoinColumn(name = "nombreSeleccionLocal", referencedColumnName = "nombreSeleccionLocal"),
            @JoinColumn(name = "nombreSeleccionVisitante", referencedColumnName = "nombreSeleccionVisitante"),
            @JoinColumn(name = "fecha", referencedColumnName = "fecha")
    })
    private Partido partido;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumns({
            @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante"),
    })
    private Estudiante estudiante;

/*
    @ManyToOne
    @MapsId("nombreSeleccionLocal")
    @JoinColumn(name = "nombreSeleccionLocal", referencedColumnName = "nombreSeleccionLocal")
    private Seleccion seleccionLocal;

    @ManyToOne
    @MapsId("nombreSeleccionVisitante")
    @JoinColumn(name = "nombreSeleccionVisitante", referencedColumnName = "nombreSeleccionVisitante")
    private Seleccion seleccionVisitante;

    @Column(name = "fecha", insertable = false, updatable = false)
    private LocalDateTime fecha;
*/

    @Column(name = "golLocal")
    private Integer golLocal;

    @Column(name = "puntaje")
    private Integer puntaje;

    @Column(name = "golVisitante")
    private Integer golVisitante;
    public Prediccion() {

    }
    public Prediccion( Estudiante estudiante, Partido partido,  Integer golLocal, Integer golVisitante, Integer puntaje) {
        this.id = new PrediccionCompositeKey(estudiante.getIdEstudiante(),partido.getSeleccionlocal().getNombre(),partido.getSeleccionvisitante().getNombre(),partido.getId().getFecha());
        this.puntaje = puntaje;
        this.partido = partido;
        this.golLocal = golLocal;
        this.golVisitante = golVisitante;
    }

    public PrediccionCompositeKey getId() {
        return id;
    }
    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public void setId(PrediccionCompositeKey id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
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
}
