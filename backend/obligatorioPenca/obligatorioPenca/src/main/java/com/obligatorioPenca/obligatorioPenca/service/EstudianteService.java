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

    public Integer registrarEstudiante(Estudiante estudiante) {
        if(estudianteRepository.obtenerEstudiantebymail(estudiante.getEmail())==null)
        {
            estudianteRepository.insertarEstudiante(
                    estudiante.getNombre(),
                    estudiante.getEmail(),
                    estudiante.getContrasena(),
                    estudiante.getCarrera()
            );
            return estudianteRepository.obtenerEstudiante(estudiante.getEmail(), estudiante.getContrasena()).getIdEstudiante();
        }
        else {
            return null;
        }
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
        return listaEstudiantes;
    }


}


