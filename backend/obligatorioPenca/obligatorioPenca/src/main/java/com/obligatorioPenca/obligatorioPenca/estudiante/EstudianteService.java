package com.obligatorioPenca.obligatorioPenca.estudiante;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public void registrarEstudiante(Estudiante estudiante) {
      estudianteRepository.insertarEstudiante(
              estudiante.getNombre(),
              estudiante.getEmail(),
              estudiante.getContrasena(),
              estudiante.getCarrera()
      );
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

