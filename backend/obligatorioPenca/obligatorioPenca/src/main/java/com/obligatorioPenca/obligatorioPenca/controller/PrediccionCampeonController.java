package com.obligatorioPenca.obligatorioPenca.controller;

import com.obligatorioPenca.obligatorioPenca.model.PrediccionCampeonDTO;
import com.obligatorioPenca.obligatorioPenca.service.PrediccionCampeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prediccionCampeon")
public class PrediccionCampeonController {

    @Autowired
    private PrediccionCampeonService prediccionCampeonService;

    @GetMapping("/{idEstudiante}")
    public List<PrediccionCampeonDTO> getPrediccionCampeonByIdEstudiante(@PathVariable String idEstudiante) {
        int studentId = Integer.parseInt(idEstudiante);
        return prediccionCampeonService.getPrediccionCampeonByIdEstudiante(studentId);
    }
    @PostMapping()
    public void postPrediccionCampeon(@RequestBody PrediccionCampeonDTO prediccionCampeonDTO) {
        prediccionCampeonService.agregarPrediccionCampeon(prediccionCampeonDTO);
    }
}
