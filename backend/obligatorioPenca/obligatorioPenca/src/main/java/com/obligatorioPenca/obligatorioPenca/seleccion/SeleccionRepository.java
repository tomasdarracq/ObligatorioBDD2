package com.obligatorioPenca.obligatorioPenca.seleccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {

    @Query("SELECT s FROM Seleccion s")
    List<Seleccion> getSelecciones();

    @Query("SELECT s FROM Seleccion s WHERE s.idSeleccion = ?1")
    Seleccion getSeleccionById(int idSeleccion);
}
