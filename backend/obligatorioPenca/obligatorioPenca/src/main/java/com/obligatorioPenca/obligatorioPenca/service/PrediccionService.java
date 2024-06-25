package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.*;
import com.obligatorioPenca.obligatorioPenca.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PrediccionService {
    private final PrediccionRepository prediccionRepository;
    private final PartidoRepository partidoRepository;
    private final EstudianteRepository estudianteRepository;
    private final PrediccionCampeonRepository prediccionCampeonRepository;
    private final SeleccionRepository seleccionRepository;

    public PrediccionService(PrediccionRepository prediccionRepository, PartidoRepository partidoRepository,
                             EstudianteRepository estudianteRepository, PrediccionCampeonRepository prediccionCampeonRepository,
                             SeleccionRepository seleccionRepository) {
        this.prediccionRepository = prediccionRepository;
        this.partidoRepository = partidoRepository;
        this.estudianteRepository = estudianteRepository;
        this.prediccionCampeonRepository = prediccionCampeonRepository;
        this.seleccionRepository = seleccionRepository;
    }

    public void revisarPuntaje() {
        LocalDateTime fechaActual = LocalDateTime.now();
        List<Partido> partidos = partidoRepository.findAllPartidos();
        List<Prediccion> predicciones = prediccionRepository.getAllPredicciones();

        for (Partido partido : partidos) {
            if (partido.getId().getFecha().isBefore(fechaActual) && partido.getGolLocal() != null && partido.getGolVisitante() != null) {
                for (Prediccion prediccion : predicciones) {
                    if (prediccion.getPartido().getId().equals(partido.getId())) {
                        int puntajePrediccion = calcularPuntaje(partido, prediccion);
                        if (prediccion.getPuntaje() != puntajePrediccion) {
                            prediccion.setPuntaje(puntajePrediccion);
                            prediccionRepository.editarPrediccion(
                                    prediccion.getId().getIdEstudiante(),
                                    prediccion.getPartido().getSeleccionlocal().getNombre(),
                                    prediccion.getPartido().getSeleccionvisitante().getNombre(),
                                    prediccion.getPartido().getId().getFecha(),
                                    prediccion.getGolLocal(),
                                    prediccion.getGolVisitante(),
                                    puntajePrediccion
                            );
                        }
                    }
                }
            }
        }
    }

    private int calcularPuntaje(Partido partido, Prediccion prediccion) {
        int goalDifferencePartido = partido.getGolLocal() - partido.getGolVisitante();
        int goalDifferencePrediccion = prediccion.getGolLocal() - prediccion.getGolVisitante();

        if (Objects.equals(partido.getGolLocal(), prediccion.getGolLocal()) && Objects.equals(partido.getGolVisitante(), prediccion.getGolVisitante())) {
            return 4;
        } else if ((goalDifferencePartido < 0 && goalDifferencePrediccion < 0) || (goalDifferencePartido > 0 && goalDifferencePrediccion > 0) || (goalDifferencePartido == 0 && goalDifferencePrediccion == 0)) {
            return 2;
        }
        return 0;
    }

    public void actualizarPuntaje() {
        revisarPuntaje();
        for (Estudiante estudiante : estudianteRepository.obtenerEstudiante()) {
            int puntaje = obtenerPuntajeEstudiante(estudiante);
            estudianteRepository.actualizarEstudiante(estudiante.getIdEstudiante(), puntaje);
        }
    }

    public int obtenerPuntajeEstudiante(Estudiante estudiante) {
        int puntajeTotal = 0;
        List<Prediccion> predicciones = prediccionRepository.findByIdEstudiante(estudiante.getIdEstudiante());
        for (Prediccion prediccion : predicciones) {
            puntajeTotal += prediccion.getPuntaje();
        }
        List<PrediccionCampeon> prediccionesCampeon = prediccionCampeonRepository.findByIdEstudiante(estudiante.getIdEstudiante());
        puntajeTotal += obtenerPuntajePrediccionCampeon(prediccionesCampeon);
        return puntajeTotal;
    }

    public int obtenerPuntajePrediccionCampeon(List<PrediccionCampeon> prediccionesCampeon) {
        int puntajeTotal = 0;
        List<Seleccion> selecciones = seleccionRepository.getSelecciones();
        for (PrediccionCampeon prediccionCampeon : prediccionesCampeon) {
            for (Seleccion seleccion : selecciones) {
                if (prediccionCampeon.getSeleccion().getNombre().equals(seleccion.getNombre())) {
                    if (prediccionCampeon.getEleccion().equals(seleccion.getEstado())) {
                        if (prediccionCampeon.getEleccion().equals("Campeón")) {
                            puntajeTotal += 10;
                        }
                        if (prediccionCampeon.getEleccion().equals("Subcampeón")) {
                            puntajeTotal += 5;
                        }
                    }
                }
            }
        }
        return puntajeTotal;
    }

    public List<PrediccionDTO> getAllPredicciones() {
        List<PrediccionDTO> prediccionDTOLista = new ArrayList<>();
        List<Prediccion> prediccionLista = prediccionRepository.getAllPredicciones();
        for (Prediccion prediccion : prediccionLista) {
            Integer idEstudiante = prediccion.getId().getIdEstudiante();
            Partido partido = prediccion.getPartido();
            String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
            String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
            LocalDateTime fechaPartido = partido.getId().getFecha();
            Integer golLocal = prediccion.getGolLocal();
            Integer golVisitante = prediccion.getGolVisitante();

            PrediccionDTO prediccionDTO = new PrediccionDTO(
                    idEstudiante,
                    nombreSeleccionLocal,
                    nombreSeleccionVisitante,
                    fechaPartido,
                    golLocal,
                    golVisitante,
                    prediccion.getPuntaje()
            );
            prediccionDTOLista.add(prediccionDTO);
        }
        return prediccionDTOLista;
    }

    public List<PrediccionDTO> getPrediccionByIdEstudiante(Integer idEstudiante) {
        List<PrediccionDTO> prediccionDTOLista = new ArrayList<>();
        List<Prediccion> prediccionLista = prediccionRepository.findByIdEstudiante(idEstudiante);
        for (Prediccion prediccion : prediccionLista) {
            Partido partido = prediccion.getPartido();
            String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
            String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
            LocalDateTime fechaPartido = partido.getId().getFecha();
            Integer golLocal = prediccion.getGolLocal();
            Integer golVisitante = prediccion.getGolVisitante();

            PrediccionDTO prediccionDTO = new PrediccionDTO(
                    idEstudiante,
                    nombreSeleccionLocal,
                    nombreSeleccionVisitante,
                    fechaPartido,
                    golLocal,
                    golVisitante,
                    prediccion.getPuntaje()
            );
            prediccionDTOLista.add(prediccionDTO);
        }
        return prediccionDTOLista;
    }

    public void agregarPrediccion(PrediccionDTO prediccionDTO) {
        prediccionRepository.agregarPrediccion(
                prediccionDTO.getIdEstudiante(),
                prediccionDTO.getNombreSeleccionLocal(),
                prediccionDTO.getNombreSeleccionVisitante(),
                prediccionDTO.getFechaPartido(),
                prediccionDTO.getGolLocal(),
                prediccionDTO.getGolVisitante(),
                prediccionDTO.getPuntaje());
    }

    public void editarPrediccion(PrediccionDTO prediccionDTO) {
        prediccionRepository.editarPrediccion(
                prediccionDTO.getIdEstudiante(),
                prediccionDTO.getNombreSeleccionLocal(),
                prediccionDTO.getNombreSeleccionVisitante(),
                prediccionDTO.getFechaPartido(),
                prediccionDTO.getGolLocal(),
                prediccionDTO.getGolVisitante(),
                prediccionDTO.getPuntaje());
        revisarPuntaje();
    }
}
