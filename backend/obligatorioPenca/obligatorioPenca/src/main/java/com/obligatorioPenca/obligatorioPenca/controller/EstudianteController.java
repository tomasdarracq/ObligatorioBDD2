package com.obligatorioPenca.obligatorioPenca.controller;


import com.obligatorioPenca.obligatorioPenca.service.EstudianteService;
import com.obligatorioPenca.obligatorioPenca.model.Estudiante;
import com.obligatorioPenca.obligatorioPenca.model.LoginDTO;

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
    public ResponseEntity<Integer> register(@RequestBody Estudiante estudiante){
        int id = estudianteService.registrarEstudiante(estudiante);
        return ResponseEntity.ok(id);
    }



    @PostMapping("/iniciarsesion")
    public  ResponseEntity<Integer>  iniciarSesion (@RequestBody LoginDTO loginDTO){
        Estudiante estudiante = estudianteService.iniciarSesion(loginDTO.email, loginDTO.contrasena);
        if(estudiante==null)
            return ResponseEntity.ok(0);
        return ResponseEntity.ok(estudiante.getIdEstudiante());
    }
    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }

}
