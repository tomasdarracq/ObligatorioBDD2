package com.obligatorioPenca.obligatorioPenca.estudiante;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoRepository;
import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeonDTO;
import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final PrediccionCampeonRepository prediccionCampeonRepository;
    public EstudianteService(EstudianteRepository estudianteRepository, PrediccionCampeonRepository prediccionCampeonRepository) {
        this.estudianteRepository = estudianteRepository;
        this.prediccionCampeonRepository = prediccionCampeonRepository;
    }

    public int registrarEstudiante(Estudiante estudiante ) {
      estudianteRepository.insertarEstudiante(
              estudiante.getNombre(),
              estudiante.getEmail(),
              estudiante.getContrasena(),
              estudiante.getCarrera()
      );
      return estudianteRepository.obtenerEstudiante(estudiante.getEmail(), estudiante.getContrasena()).getIdEstudiante();
      }







    public Estudiante iniciarSesion(String email, String contrasena){
        Estudiante student = estudianteRepository.obtenerEstudiante(email, contrasena);
        if (student != null) {
                return student;
        }
        return null;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes(){
        return estudianteRepository.obtenerEstudiante();
    }



}

