package com.obligatorioPenca.obligatorioPenca.partido;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PartidocompositeKey implements Serializable {
    @Column(name = "seleccionlocal_id")
    private Long seleccionlocalId;

    @Column(name = "seleccionvisitante_id")
    private Long seleccionvisitanteId;

    @Column(name = "fecha")
    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

// Constructores, getters y setters

    public PartidocompositeKey() {
    }


    public PartidocompositeKey(Long seleccionlocalId, Long seleccionvisitanteId, LocalDate fecha) {
        this.seleccionlocalId = seleccionlocalId;
        this.seleccionvisitanteId = seleccionvisitanteId;
        this.fecha = fecha;
    }



    public Long getSeleccionlocalId() {
        return seleccionlocalId;
    }

    public void setSeleccionlocalId(Long seleccionlocalId) {
        this.seleccionlocalId = seleccionlocalId;
    }

    public Long getSeleccionvisitanteId() {
        return seleccionvisitanteId;
    }

    public void setSeleccionvisitanteId(Long seleccionvisitanteId) {
        this.seleccionvisitanteId = seleccionvisitanteId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidocompositeKey that = (PartidocompositeKey) o;
        return Objects.equals(seleccionlocalId, that.seleccionlocalId) &&
                Objects.equals(seleccionvisitanteId, that.seleccionvisitanteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seleccionlocalId, seleccionvisitanteId);
    }
}
