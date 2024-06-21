package com.obligatorioPenca.obligatorioPenca.repository;

import com.obligatorioPenca.obligatorioPenca.model.Seleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, String> {

    @Query("SELECT s FROM  Seleccion s")
    List<Seleccion> getSelecciones();

    @Query("SELECT s FROM Seleccion s WHERE s.nombre = ?1")
    Seleccion getSeleccionByNombre(String nombre);
}
