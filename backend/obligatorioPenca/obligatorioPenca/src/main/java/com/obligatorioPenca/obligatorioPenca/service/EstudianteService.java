package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.Prediccion;

import com.obligatorioPenca.obligatorioPenca.model.Estudiante;
import com.obligatorioPenca.obligatorioPenca.model.PrediccionCampeon;
import com.obligatorioPenca.obligatorioPenca.model.Seleccion;
import com.obligatorioPenca.obligatorioPenca.repository.EstudianteRepository;
import com.obligatorioPenca.obligatorioPenca.repository.PrediccionCampeonRepository;
import com.obligatorioPenca.obligatorioPenca.repository.PrediccionRepository;

import com.obligatorioPenca.obligatorioPenca.repository.SeleccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final PrediccionRepository prediccionRepository;
    private final SeleccionRepository seleccionRepository;

    private final PrediccionCampeonRepository prediccionCampeonRepository;

    public EstudianteService(EstudianteRepository estudianteRepository, PrediccionCampeonRepository prediccionCampeonRepository, PrediccionRepository prediccionRepository, SeleccionRepository seleccionRepository) {
        this.estudianteRepository = estudianteRepository;
        this.prediccionCampeonRepository = prediccionCampeonRepository;
        this.prediccionRepository = prediccionRepository;
        this.seleccionRepository = seleccionRepository;
    }

    public int registrarEstudiante(Estudiante estudiante) {
        estudianteRepository.insertarEstudiante(
                estudiante.getNombre(),
                estudiante.getEmail(),
                estudiante.getContrasena(),
                estudiante.getCarrera()
        );
        return estudianteRepository.obtenerEstudiante(estudiante.getEmail(), estudiante.getContrasena()).getIdEstudiante();
    }


    public Estudiante iniciarSesion(String email, String contrasena) {
        Estudiante student = estudianteRepository.obtenerEstudiante(email, contrasena);
        if (student != null) {
            return student;
        }
        return null;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
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

    public int obtenerPuntajeEstudiante(Estudiante estudiante) {
        int puntajeTotal = 0;
        List<Prediccion> predicciones = prediccionRepository.findByIdEstudiante(estudiante.getIdEstudiante());
        System.out.println(predicciones);
        for (Prediccion prediccion : predicciones) {
            puntajeTotal = puntajeTotal + prediccion.getPuntaje();
        }
        List<PrediccionCampeon> prediccionesCampeon = prediccionCampeonRepository.findByIdEstudiante(estudiante.getIdEstudiante());
        puntajeTotal = puntajeTotal+ obtenerPuintajePrediccionCampeon(prediccionesCampeon);
        return puntajeTotal;
    }
    public int obtenerPuintajePrediccionCampeon(List<PrediccionCampeon> prediccionesCampeon){
        int puntajeTotal = 0;
        List<Seleccion> selecciones = seleccionRepository.getSelecciones();
        for (PrediccionCampeon prediccionCampeon : prediccionesCampeon) {
            for (Seleccion seleccion : selecciones) {
                if (prediccionCampeon.getSeleccion().getNombre().equals(seleccion.getNombre())) {
                    if (prediccionCampeon.getEleccion().equals(seleccion.getEstado())) {
                        if(prediccionCampeon.getEleccion().equals("Campeon")){
                            puntajeTotal = puntajeTotal + 10;
                        }
                        if(prediccionCampeon.getEleccion().equals("Subcampeon")){
                            puntajeTotal = puntajeTotal + 5;
                        }

                    }
                }
            }
        }
        return puntajeTotal;
    }

}


