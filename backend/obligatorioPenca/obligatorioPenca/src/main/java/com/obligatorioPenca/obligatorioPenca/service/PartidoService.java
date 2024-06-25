package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.*;
import com.obligatorioPenca.obligatorioPenca.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;
    private final PrediccionRepository prediccionRepository;
    private final PrediccionCampeonRepository prediccionCampeonRepository;
    private final EstudianteRepository estudianteRepository;
    private final SeleccionRepository seleccionRepository;


    public PartidoService(PartidoRepository partidoRepository, PrediccionRepository prediccionRepository, PrediccionCampeonRepository prediccionCampeonRepository,
                          EstudianteRepository estudianteRepository, SeleccionRepository seleccionRepository) {
        this.partidoRepository = partidoRepository;
        this.prediccionRepository = prediccionRepository;
        this.prediccionCampeonRepository = prediccionCampeonRepository;
        this.estudianteRepository = estudianteRepository;
        this.seleccionRepository = seleccionRepository;
    }

    public PartidoDTO crearPartido(PartidoDTO partidoDTO) {
        partidoRepository.insertarPartido(
                partidoDTO.getSeleccionLocalNombre(),
                partidoDTO.getSeleccionVisitanteNombre(),
                partidoDTO.getFecha(),
                partidoDTO.getGolesLocal(),
                partidoDTO.getGolesVisitante()
        );
        return partidoDTO;
    }

    public List<PartidoDTO> obtenerPartidosDTO() {
        List<Partido> partidos = partidoRepository.findAllPartidos();
        List<PartidoDTO> partidosDTO = new ArrayList<>();

        for (Partido partido : partidos) {
            PartidoDTO partidoDTO = new PartidoDTO(
                    partido.getSeleccionlocal().getNombre(),
                    partido.getSeleccionvisitante().getNombre(),
                    partido.getGolLocal(),
                    partido.getGolVisitante(),
                    partido.getId().getFecha()
            );
            partidosDTO.add(partidoDTO);
        }
        return partidosDTO;
    }

    public List<PartidoDTO> obtenerPartidoByFecha(LocalDateTime fecha){
        List<Partido> partidos= partidoRepository.findAllbyFecha(fecha);
        List<PartidoDTO> partidosDTO = new ArrayList<>();

        for (Partido partido : partidos) {
            PartidoDTO partidoDTO = new PartidoDTO(
                    partido.getSeleccionlocal().getNombre(),
                    partido.getSeleccionvisitante().getNombre(),
                    partido.getGolLocal(),
                    partido.getGolVisitante(),
                    partido.getId().getFecha()
            );
            partidosDTO.add(partidoDTO);
        }
        return partidosDTO;
    }

    public Integer agregarGoles(PartidoDTO partidoDTO){
    partidoRepository.actualizarGolesPartido(partidoDTO.getSeleccionLocalNombre(),
            partidoDTO.getSeleccionVisitanteNombre(),
            partidoDTO.getFecha(),
            partidoDTO.getGolesLocal(),
            partidoDTO.getGolesVisitante());
    actualizarPuntaje();

    return partidoDTO.getGolesLocal();

    }


    public void actualizarPuntaje(){
        int puntaje = 0;
        for (Estudiante estudiante : estudianteRepository.obtenerEstudiante()) {
                 puntaje = obtenerPuntajeEstudiante(estudiante);
                estudianteRepository.actualizarEstudiante(estudiante.getIdEstudiante(),puntaje);
        }


    }
    public int obtenerPuntajeEstudiante(Estudiante estudiante) {
        int puntajeTotal = 0;
        List<Prediccion> predicciones = prediccionRepository.findByIdEstudiante(estudiante.getIdEstudiante());
        System.out.println(predicciones);
        for (Prediccion prediccion : predicciones) {
            puntajeTotal = puntajeTotal + prediccion.getPuntaje();
        }
        List<PrediccionCampeon> prediccionesCampeon = prediccionCampeonRepository.findByIdEstudiante(estudiante.getIdEstudiante());
        puntajeTotal = puntajeTotal+ obtenerPuntajePrediccionCampeon(prediccionesCampeon);
        return puntajeTotal;
    }
    public int obtenerPuntajePrediccionCampeon(List<PrediccionCampeon> prediccionesCampeon) {
        int puntajeTotal = 0;
        List<Seleccion> selecciones = seleccionRepository.getSelecciones();
        for (PrediccionCampeon prediccionCampeon : prediccionesCampeon) {
            for (Seleccion seleccion : selecciones) {
                if (prediccionCampeon.getSeleccion().getNombre().equals(seleccion.getNombre())) {
                    if (prediccionCampeon.getEleccion().equals(seleccion.getEstado())) {
                        if (prediccionCampeon.getEleccion().equals("Campeon")) {
                            puntajeTotal = puntajeTotal + 10;
                        }
                        if (prediccionCampeon.getEleccion().equals("Subcampeon")) {
                            puntajeTotal = puntajeTotal + 5;
                        }

                    }
                }
            }
        }
        return puntajeTotal;
    }

    
}

