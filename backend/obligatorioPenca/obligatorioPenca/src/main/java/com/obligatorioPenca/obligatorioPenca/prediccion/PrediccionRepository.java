package com.obligatorioPenca.obligatorioPenca.prediccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrediccionRepository extends JpaRepository<Prediccion, PrediccionCompositeKey> {

    @Query("SELECT p FROM Prediccion p")
    List<Prediccion> getallPredicciones();

    @Query("SELECT p FROM Prediccion p WHERE p.id.idPrediccion = ?1")
    Prediccion getPrediccionByIdPrediccion(Integer idPrediccion);

    @Query("SELECT p FROM Prediccion p WHERE p.id.idEstudiante = ?1")
    Prediccion getPrediccionByIdEstudiante(Integer idEstudiante);

}
