package com.obligatorioPenca.obligatorioPenca.prediccion;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrediccionService {
    private final PrediccionRepository PrediccionRepository;

    public PrediccionService(PrediccionRepository prediccionRepository) {
        this.PrediccionRepository = prediccionRepository;
    }

    public List<PrediccionDTO> mapPrediccionToDTO() {
        List<PrediccionDTO> prediccionDTOLista = new ArrayList<>();
        List<Prediccion> prediccionLista = PrediccionRepository.getAllPredicciones();
        for (Prediccion prediccion : prediccionLista) {
            Partido partido = prediccion.getPartido();
            String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
            String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
            LocalDateTime fechaPartido = partido.getId().getFecha();
            Integer golLocal = prediccion.getGolLocal();
            Integer golVisitante = prediccion.getGolVisitante();
            Integer puntaje = prediccion.getPuntaje();
            //  Integer idPrediccion = prediccion.getId().getIdPrediccion();
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
            //prediccionDTO.setIdPrediccion(idPrediccion);
            prediccionDTOLista.add(prediccionDTO);
        }

        return prediccionDTOLista;
    }

    public List<PrediccionDTO> getPrediccionByIdEstudiante(Integer idEstudiante) {
        List<PrediccionDTO> prediccionDTOLista = new ArrayList<>();
        List<Prediccion> prediccionLista = PrediccionRepository.findByIdEstudiante(idEstudiante);
        for (Prediccion prediccion : prediccionLista) {
            Partido partido = prediccion.getPartido();
            String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
            String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
            LocalDateTime fechaPartido = partido.getId().getFecha();
            Integer golLocal = prediccion.getGolLocal();
            Integer golVisitante = prediccion.getGolVisitante();
            Integer puntaje = prediccion.getPuntaje();
            //  Integer idPrediccion = prediccion.getId().getIdPrediccion();


            PrediccionDTO prediccionDTO = new PrediccionDTO(
                    idEstudiante,
                    nombreSeleccionLocal,
                    nombreSeleccionVisitante,
                    fechaPartido,
                    golLocal,
                    golVisitante,
                    puntaje

            );
            //prediccionDTO.setIdPrediccion(idPrediccion);
            prediccionDTOLista.add(prediccionDTO);
        }
        return prediccionDTOLista;
    }


    public void agregarPrediccion(PrediccionDTO prediccionDTO) {
        // prediccionDTO.setIdPrediccion(key.getIdPrediccion());
        PrediccionRepository.agregarPrediccion(
                prediccionDTO.getIdEstudiante(),
                prediccionDTO.getNombreSeleccionLocal(),
                prediccionDTO.getNombreSeleccionVisitante(),
                prediccionDTO.getFechaPartido(),
                prediccionDTO.getGolLocal(),
                prediccionDTO.getGolVisitante(),
                prediccionDTO.getPuntaje());


    }


}