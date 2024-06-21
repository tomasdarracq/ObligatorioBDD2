package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.Partido;
import com.obligatorioPenca.obligatorioPenca.model.Prediccion;
import com.obligatorioPenca.obligatorioPenca.model.PrediccionDTO;
import com.obligatorioPenca.obligatorioPenca.repository.PrediccionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrediccionService {
    private final PrediccionRepository prediccionRepository;

    public PrediccionService(PrediccionRepository prediccionRepository) {
        this.prediccionRepository = prediccionRepository;
    }

    public List<PrediccionDTO> mapPrediccionToDTO() {
        List<PrediccionDTO> prediccionDTOLista = new ArrayList<>();
        List<Prediccion> prediccionLista = prediccionRepository.getAllPredicciones();
        for (Prediccion prediccion : prediccionLista) {
            Partido partido = prediccion.getPartido();
            String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
            String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
            LocalDateTime fechaPartido = partido.getId().getFecha();
            Integer golLocal = prediccion.getGolLocal();
            Integer golVisitante = prediccion.getGolVisitante();
            Integer puntaje = prediccion.getPuntaje();
            Integer idEstudiante = prediccion.getId().getIdEstudiante();

            PrediccionDTO prediccionDTO = new PrediccionDTO(
                    idEstudiante,
                    nombreSeleccionLocal,
                    nombreSeleccionVisitante,
                    fechaPartido,
                    golLocal,
                    golVisitante,
                    puntaje
            );
            prediccionDTOLista.add(prediccionDTO);
        }
        return prediccionDTOLista;
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

            LocalDateTime fechaActual = LocalDateTime.now();

            if (partido.getId().getFecha().isBefore(fechaActual)) {
                if (partido.getGolLocal() == prediccion.getGolLocal() && partido.getGolVisitante() == prediccion.getGolVisitante()) {
                    prediccion.setPuntaje(4);
                } else {
                    int ganadorPartido = partido.getGolLocal() - partido.getGolVisitante();
                    int ganadorPrediccion = prediccion.getGolLocal() - prediccion.getGolVisitante();
                    if ((ganadorPartido < 0 && ganadorPrediccion < 0) || (ganadorPartido > 0 && ganadorPrediccion > 0) || (ganadorPartido == 0 && ganadorPrediccion == 0)) {
                        prediccion.setPuntaje(2);
                    } else {
                        prediccion.setPuntaje(0);
                    }
                }
            }
            Integer puntaje = prediccion.getPuntaje();

            PrediccionDTO prediccionDTO = new PrediccionDTO(
                    idEstudiante,
                    nombreSeleccionLocal,
                    nombreSeleccionVisitante,
                    fechaPartido,
                    golLocal,
                    golVisitante,
                    puntaje
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

            LocalDateTime fechaActual = LocalDateTime.now();

            if (partido.getId().getFecha().isBefore(fechaActual)) {
                if (partido.getGolLocal() == prediccion.getGolLocal() && partido.getGolVisitante() == prediccion.getGolVisitante()) {
                    prediccion.setPuntaje(4);
                } else {
                    int ganadorPartido = partido.getGolLocal() - partido.getGolVisitante();
                    int ganadorPrediccion = prediccion.getGolLocal() - prediccion.getGolVisitante();
                    if ((ganadorPartido < 0 && ganadorPrediccion < 0) || (ganadorPartido > 0 && ganadorPrediccion > 0) || (ganadorPartido == 0 && ganadorPrediccion == 0)) {
                        prediccion.setPuntaje(2);
                    } else {
                        prediccion.setPuntaje(0);
                    }
                }
            }
            Integer puntaje = prediccion.getPuntaje();

            PrediccionDTO prediccionDTO = new PrediccionDTO(
                    idEstudiante,
                    nombreSeleccionLocal,
                    nombreSeleccionVisitante,
                    fechaPartido,
                    golLocal,
                    golVisitante,
                    puntaje
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
                prediccionDTO.getGolVisitante());
        System.out.println(prediccionDTO.getGolLocal());
    }
}
