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
        List<Prediccion> prediccionLista = PrediccionRepository.getallPredicciones();
        for (Prediccion prediccion : prediccionLista) {
            Partido partido = prediccion.getPartido();
            String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
            String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
            LocalDateTime fechaPartido = partido.getId().getFecha();
            Integer golLocal = prediccion.getGolLocal();
            Integer golVisitante = prediccion.getGolVisitante();
            Integer puntaje = prediccion.getPuntaje();

            PrediccionDTO prediccionDTO = new PrediccionDTO(
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

    public PrediccionDTO getPrediccionByIdEstudiante(Integer idEstudiante) {
        Prediccion prediccion = PrediccionRepository.getPrediccionByIdEstudiante(idEstudiante);
        Partido partido = prediccion.getPartido();
        String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
        String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
        LocalDateTime fechaPartido = partido.getId().getFecha();
        Integer golLocal = prediccion.getGolLocal();
        Integer golVisitante = prediccion.getGolVisitante();
        Integer puntaje = prediccion.getPuntaje();


        PrediccionDTO prediccionDTO = new PrediccionDTO(
                nombreSeleccionLocal,
                nombreSeleccionVisitante,
                fechaPartido,
                golLocal,
                golVisitante,
                puntaje
        );
        return prediccionDTO;
    }

    public PrediccionDTO getPrediccionByIdPrediccion(Integer idPrediccion) {
        Prediccion prediccion = PrediccionRepository.getPrediccionByIdPrediccion(idPrediccion);
        Partido partido = prediccion.getPartido();
        String nombreSeleccionLocal = partido.getSeleccionlocal().getNombre();
        String nombreSeleccionVisitante = partido.getSeleccionvisitante().getNombre();
        LocalDateTime fechaPartido = partido.getId().getFecha();
        Integer golLocal = prediccion.getGolLocal();
        Integer golVisitante = prediccion.getGolVisitante();
        Integer puntaje = prediccion.getPuntaje();


        PrediccionDTO prediccionDTO = new PrediccionDTO(
                nombreSeleccionLocal,
                nombreSeleccionVisitante,
                fechaPartido,
                golLocal,
                golVisitante,
                puntaje
        );
        return prediccionDTO;
    }
}
