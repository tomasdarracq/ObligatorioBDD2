package com.obligatorioPenca.obligatorioPenca.repository;

import com.obligatorioPenca.obligatorioPenca.model.Estudiante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Estudiante (nombre, email, contrasena, carrera) VALUES ( :nombre, :email, :contrasena, :carrera)",
            nativeQuery = true
    )
    void insertarEstudiante(
                            @Param("nombre") String nombre,
                            @Param("email") String email,
                            @Param("contrasena") String contrasena,
                            @Param("carrera") String carrera
                            );



    @Query(value = "SELECT * FROM Estudiante", nativeQuery = true)
    List<Estudiante> obtenerEstudiante();
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE Estudiante SET puntajeTotal = :puntajeTotal WHERE idEstudiante = :idEstudiante",
            nativeQuery = true
    )
    void actualizarEstudiante(@Param("idEstudiante") Integer idEstudiante,
                              @Param("puntajeTotal") Integer puntajeTotal);

    @Query(value = "SELECT * FROM Estudiante WHERE email = :email AND contrasena = :contrasena", nativeQuery = true)
    Estudiante obtenerEstudiante(@Param("email") String email,
                                 @Param("contrasena") String contrasena);

    @Query(value = "SELECT * FROM Estudiante WHERE email = :email", nativeQuery = true)
    Estudiante obtenerEstudiantebymail(@Param("email") String email);

}

