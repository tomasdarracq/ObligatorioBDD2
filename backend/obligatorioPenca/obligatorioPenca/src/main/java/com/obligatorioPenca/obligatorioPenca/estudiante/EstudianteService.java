package com.obligatorioPenca.obligatorioPenca.estudiante;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoRepository;
import com.obligatorioPenca.obligatorioPenca.prediccion.Prediccion;
import com.obligatorioPenca.obligatorioPenca.prediccion.PrediccionRepository;
import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeonDTO;
import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.obligatorioPenca.obligatorioPenca.estudiante.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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


