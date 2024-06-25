package com.obligatorioPenca.obligatorioPenca.repository;

import com.obligatorioPenca.obligatorioPenca.model.Seleccion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, String> {

    @Query("SELECT s FROM  Seleccion s")
    List<Seleccion> getSelecciones();

    @Query("SELECT s FROM Seleccion s WHERE s.nombre = ?1")
    Seleccion getSeleccionByNombre(String nombre);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Seleccion s SET s.estado = ?2 where s.nombre = ?1", nativeQuery = true)
    void actualizarSeleccion(@Param("nombre") String nombre,
                             @Param("estado") String estado);
}
