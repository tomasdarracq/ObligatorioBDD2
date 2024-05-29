package com.obligatorioPenca.obligatorioPenca.prediccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/prediccion")
@CrossOrigin(origins = "http://localhost:4200")
public class PrediccionController {

   private final PrediccionService PrediccionService;

    @Autowired
    public PrediccionController(PrediccionService prediccionService) {
        PrediccionService = prediccionService;
    }

    @GetMapping
    public List<PrediccionDTO> getPredicciones() {
        List<PrediccionDTO> prediccionDTO = PrediccionService.mapPrediccionToDTO();
        return prediccionDTO;

    }
    @GetMapping("/estudiante/{idEstudiante}")
    public List<PrediccionDTO> getPrediccionByIdEstudiante(@PathVariable String idEstudiante) {
        List<PrediccionDTO> prediccionDTO = PrediccionService.getPrediccionByIdEstudiante(Integer.parseInt(idEstudiante));
        return prediccionDTO        ;
    }

    @PostMapping
    public void postPrediccion(@RequestBody PrediccionDTO prediccionDTO){
     PrediccionService.agregarPrediccion(prediccionDTO);
    }


}
