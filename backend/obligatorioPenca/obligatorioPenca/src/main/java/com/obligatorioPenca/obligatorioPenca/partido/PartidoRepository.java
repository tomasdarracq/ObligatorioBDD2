package com.obligatorioPenca.obligatorioPenca.partido;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository  <Partido,PartidocompositeKey> {
    @Query(value="SELECT * FROM Partido ", nativeQuery = true)
    List<Partido> findAllPartidos();


    @Query(value="SELECT * from Partido p WHERE p.fecha = ?1", nativeQuery = true)
    List<Partido> findAllbyFecha(LocalDateTime fecha);

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Partido (nombreSeleccionLocal, nombreSeleccionVisitante, fecha, golLocal, golVisitante) VALUES (:nombreSeleccionLocal, :nombreSeleccionVisitante, :fecha, :golLocal, :golVisitante)",
            nativeQuery = true)
    void insertarPartido(@Param("nombreSeleccionLocal") String nombreSeleccionLocal,
                         @Param("nombreSeleccionVisitante") String nombreSeleccionVisitante,
                         @Param("fecha") LocalDateTime fecha,
                         @Param("golLocal") int golLocal,
                         @Param("golVisitante") int golVisitante);




}
