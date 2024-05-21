package com.obligatorioPenca.obligatorioPenca.partido;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class PartidocompositeKey implements Serializable {
    @Column(name = "nombreSeleccionLocal", length = 50)
    private String nombreSeleccionLocal;

    @Column(name = "nombreSeleccionVisitante", length = 50)
    private String nombreSeleccionVisitante;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public PartidocompositeKey() {}

    public PartidocompositeKey(String nombreSeleccionLocal, String nombreSeleccionVisitante, LocalDateTime fecha) {
        this.nombreSeleccionLocal = nombreSeleccionLocal;
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
        this.fecha = fecha;
    }

    public String getNombreSeleccionLocal() {
        return nombreSeleccionLocal;
    }

    public void setNombreSeleccionLocal(String nombreSeleccionLocal) {
        this.nombreSeleccionLocal = nombreSeleccionLocal;
    }

    public String getNombreSeleccionVisitante() {
        return nombreSeleccionVisitante;
    }

    public void setNombreSeleccionVisitante(String nombreSeleccionVisitante) {
        this.nombreSeleccionVisitante = nombreSeleccionVisitante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidocompositeKey that = (PartidocompositeKey) o;
        return Objects.equals(nombreSeleccionLocal, that.nombreSeleccionLocal) &&
                Objects.equals(nombreSeleccionVisitante, that.nombreSeleccionVisitante) &&
                Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreSeleccionLocal, nombreSeleccionVisitante, fecha);
    }
}
