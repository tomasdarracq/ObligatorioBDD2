package com.obligatorioPenca.obligatorioPenca.prediccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/prediccion")
@CrossOrigin(origins = "http://localhost:4200")
public class PrediccionController {

    private final PrediccionService prediccionService;

    @Autowired
    public PrediccionController(PrediccionService prediccionService) {
        this.prediccionService = prediccionService;
    }

    @GetMapping
    public List<PrediccionDTO> getPredicciones() {
        return prediccionService.getAllPredicciones();
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public List<PrediccionDTO> getPrediccionByIdEstudiante(@PathVariable String idEstudiante) {
        return prediccionService.getPrediccionByIdEstudiante(Integer.parseInt(idEstudiante));
    }

    @PostMapping
    public void postPrediccion(@RequestBody PrediccionDTO prediccionDTO) {
        prediccionService.agregarPrediccion(prediccionDTO);
    }

    @PutMapping
    public void putPrediccion(@RequestBody PrediccionDTO prediccionDTO) {
        prediccionService.editarPrediccion(prediccionDTO);
    }
}