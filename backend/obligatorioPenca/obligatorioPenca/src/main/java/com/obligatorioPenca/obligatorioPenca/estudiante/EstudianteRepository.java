package com.obligatorioPenca.obligatorioPenca.estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    @Query("SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante")
    Estudiante getDatosEstudianteById(@Param("idEstudiante") Integer idEstudiante);

    @Query("SELECT e FROM Estudiante e ")
    List<Estudiante>  obtenerTodosLosEstudiantes();

}
