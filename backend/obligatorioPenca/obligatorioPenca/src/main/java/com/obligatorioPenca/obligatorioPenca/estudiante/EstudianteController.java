package com.obligatorioPenca.obligatorioPenca.estudiante;

import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @PostMapping("/iniciarsesion")
    public  ResponseEntity<Integer>  iniciarSesion (@RequestBody LoginDTO loginDTO){
        Estudiante estudiante = estudianteService.iniciarsesion(loginDTO.email, loginDTO.contrasena);
        if(estudiante==null)
            return ResponseEntity.ok(0);
        return ResponseEntity.ok(estudiante.getIdEstudiante());
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }
















}
