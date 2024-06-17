package com.obligatorioPenca.obligatorioPenca.estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/estudiante")
public class EstudianteController {
    @Autowired
    private final EstudianteService estudianteService;
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Estudiante estudiante){
        estudianteService.registrarEstudiante(estudiante);
        return ResponseEntity.ok("El estudiante se registro correctamente");
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }

}
