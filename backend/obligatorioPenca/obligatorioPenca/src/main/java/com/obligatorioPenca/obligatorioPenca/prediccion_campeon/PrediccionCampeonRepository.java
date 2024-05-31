package com.obligatorioPenca.obligatorioPenca.prediccion_campeon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrediccionCampeonRepository extends JpaRepository<PrediccionCampeon, PrediccionCampeonCompositeKey> {

    @Query("SELECT p FROM PrediccionCampeon p WHERE p.estudiante.id = :idEstudiante")
    List<PrediccionCampeon> findByIdEstudiante(@Param("idEstudiante") Integer idEstudiante);
}
