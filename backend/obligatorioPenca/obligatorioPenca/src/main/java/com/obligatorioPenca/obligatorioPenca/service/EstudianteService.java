package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.Prediccion;

import com.obligatorioPenca.obligatorioPenca.model.Estudiante;
import com.obligatorioPenca.obligatorioPenca.repository.EstudianteRepository;
import com.obligatorioPenca.obligatorioPenca.repository.PrediccionCampeonRepository;
import com.obligatorioPenca.obligatorioPenca.repository.PrediccionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final PrediccionRepository prediccionRepository;

    private final PrediccionCampeonRepository prediccionCampeonRepository;

    public EstudianteService(EstudianteRepository estudianteRepository, PrediccionCampeonRepository prediccionCampeonRepository, PrediccionRepository prediccionRepository) {
        this.estudianteRepository = estudianteRepository;
        this.prediccionCampeonRepository = prediccionCampeonRepository;
        this.prediccionRepository = prediccionRepository;
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
            List<Estudiante> listaEstudiantes = estudianteRepository.obtenerEstudiante();
            for (Estudiante estudiante : listaEstudiantes) {
                {
                    int puntaje = obtenerPuntajeEstudiante(estudiante);
                    System.out.println(puntaje);
                    estudiante.setPuntajeTotal(puntaje);
            }
        }
            return listaEstudiantes;
        }

        public int obtenerPuntajeEstudiante(Estudiante estudiante){
            int puntajeTotal = 0;
            List<Prediccion> predicciones = prediccionRepository.findByIdEstudiante(estudiante.getIdEstudiante());
            System.out.println(predicciones);
            for (Prediccion prediccion : predicciones) {
                    puntajeTotal = puntajeTotal + prediccion.getPuntaje();
        }
            return puntajeTotal;
    }
    }


