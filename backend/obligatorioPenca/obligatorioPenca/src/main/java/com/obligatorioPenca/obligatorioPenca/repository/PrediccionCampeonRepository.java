package com.obligatorioPenca.obligatorioPenca.repository;

import com.obligatorioPenca.obligatorioPenca.model.PrediccionCampeon;
import com.obligatorioPenca.obligatorioPenca.model.PrediccionCampeonCompositeKey;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrediccionCampeonRepository extends JpaRepository<PrediccionCampeon, PrediccionCampeonCompositeKey> {

    @Query("SELECT p FROM PrediccionCampeon p WHERE p.estudiante.id = :idEstudiante")
    List<PrediccionCampeon> findByIdEstudiante(@Param("idEstudiante") Integer idEstudiante);

   @Modifying
   @Transactional
    @Query(
            value = "INSERT INTO Estudiante_Elige_Seleccion (idEstudiante, nombreSeleccion, eleccion) VALUES (:idEstudiante, :nombreSeleccion, :eleccion) ",
            nativeQuery = true
    )
   void agregarPrediccionCampeon(
           @Param("idEstudiante") Integer idEstudiante,
           @Param("nombreSeleccion") String nombreSeleccion,
           @Param("eleccion") String eleccion);



}
