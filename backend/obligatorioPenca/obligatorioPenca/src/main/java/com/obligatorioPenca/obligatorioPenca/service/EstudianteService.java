package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.Estudiante;
import com.obligatorioPenca.obligatorioPenca.repository.EstudianteRepository;
import com.obligatorioPenca.obligatorioPenca.repository.PrediccionCampeonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    private final PrediccionCampeonRepository prediccionCampeonRepository;

    public EstudianteService(EstudianteRepository estudianteRepository, PrediccionCampeonRepository prediccionCampeonRepository) {
        this.estudianteRepository = estudianteRepository;
        this.prediccionCampeonRepository = prediccionCampeonRepository;
    }

        public int registrarEstudiante (Estudiante estudiante ){
            estudianteRepository.insertarEstudiante(
                    estudiante.getNombre(),
                    estudiante.getEmail(),
                    estudiante.getContrasena(),
                    estudiante.getCarrera()
            );
            return estudianteRepository.obtenerEstudiante(estudiante.getEmail(), estudiante.getContrasena()).getIdEstudiante();
        }


        public Estudiante iniciarSesion (String email, String contrasena){
            Estudiante student = estudianteRepository.obtenerEstudiante(email, contrasena);
            if (student != null) {
                return student;
            }
            return null;
        }

        public List<Estudiante> obtenerTodosLosEstudiantes () {
            return estudianteRepository.obtenerEstudiante();
        }

    }


