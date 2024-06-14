package com.obligatorioPenca.obligatorioPenca.Login;

import com.obligatorioPenca.obligatorioPenca.estudiante.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository <Estudiante,Integer>{

    @Query(value = "SELECT idAdmin AS idUsuario FROM Administrador WHERE email = :email AND contrasena = :contrasena " +
            "UNION " +
            "SELECT idEstudiante AS idUsuario FROM Estudiante WHERE email = :email AND contrasena = :contrasena", nativeQuery = true)
    Integer obtenerIdUsuario(@Param("email") String email, @Param("contrasena") String contrasena);
}
