package com.obligatorioPenca.obligatorioPenca.prediccion_campeon;

import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrediccionCampeonController {

    @Autowired
    private PrediccionCampeonService prediccionCampeonService;

    @GetMapping("prediccionCampeon/{idEstudiante}")
    public List<PrediccionCampeonDTO> getPrediccionCampeonByIdEstudiante(@PathVariable String idEstudiante) {
        int studentId = Integer.parseInt(idEstudiante);
        return prediccionCampeonService.getPrediccionCampeonByIdEstudiante(studentId);
    }

}
