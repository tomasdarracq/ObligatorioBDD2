package com.obligatorioPenca.obligatorioPenca.estudiante;

import jakarta.transaction.Transactional;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
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


}
