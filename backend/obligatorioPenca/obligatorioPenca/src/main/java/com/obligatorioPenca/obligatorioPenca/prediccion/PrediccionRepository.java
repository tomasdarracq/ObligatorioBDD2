package com.obligatorioPenca.obligatorioPenca.prediccion;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PrediccionRepository extends JpaRepository<Prediccion, PrediccionCompositeKey> {

    @Query("SELECT p FROM Prediccion p")
    List<Prediccion> getAllPredicciones();

    @Query("SELECT p FROM Prediccion p WHERE p.id.idEstudiante = :idEstudiante")
    List<Prediccion> findByIdEstudiante(@Param("idEstudiante") Integer idEstudiante);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Estudiante_Realiza_Prediccion (idEstudiante, nombreSeleccionLocal, nombreSeleccionVisitante, fecha, golLocal, golVisitante, puntaje) VALUES (:idEstudiante, :nombreSeleccionLocal, :nombreSeleccionVisitante, :fecha, :golLocal, :golVisitante, :puntaje)",
            nativeQuery = true)
    void agregarPrediccion(
            @Param("idEstudiante") Integer idEstudiante,
            @Param("nombreSeleccionLocal") String nombreSeleccionLocal,
            @Param("nombreSeleccionVisitante") String nombreSeleccionVisitante,
            @Param("fecha") LocalDateTime fecha,
            @Param("golLocal") int golLocal,
            @Param("golVisitante") int golVisitante,
            @Param("puntaje") int puntaje);
}
