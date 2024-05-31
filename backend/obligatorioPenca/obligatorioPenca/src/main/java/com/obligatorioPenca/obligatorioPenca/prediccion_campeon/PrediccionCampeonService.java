package com.obligatorioPenca.obligatorioPenca.prediccion_campeon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrediccionCampeonService {

    @Autowired
    private PrediccionCampeonRepository prediccionCampeonRepository;

    public List<PrediccionCampeonDTO> getPrediccionCampeonByIdEstudiante(int idEstudiante) {
        List<PrediccionCampeonDTO> prediccionCampeonDTOList = new ArrayList<>();
        List<PrediccionCampeon> prediccionCampeonLista = prediccionCampeonRepository.findByIdEstudiante(idEstudiante);

        for (PrediccionCampeon prediccionCampeon : prediccionCampeonLista) {
            String nombreSeleccion = prediccionCampeon.getSeleccion().getNombre();
            String eleccion = prediccionCampeon.getEleccion();

            PrediccionCampeonDTO prediccionCampeonDTO = new PrediccionCampeonDTO(
                    idEstudiante,
                    nombreSeleccion,
                    eleccion
            );

            prediccionCampeonDTOList.add(prediccionCampeonDTO);
        }

        return prediccionCampeonDTOList;
    }
}
