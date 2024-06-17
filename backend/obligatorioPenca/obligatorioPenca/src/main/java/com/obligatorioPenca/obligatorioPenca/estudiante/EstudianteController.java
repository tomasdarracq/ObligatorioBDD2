package com.obligatorioPenca.obligatorioPenca.estudiante;

<<<<<<< HEAD
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeon;
import com.obligatorioPenca.obligatorioPenca.prediccion_campeon.PrediccionCampeonDTO;
=======
>>>>>>> 7d08b1608bf2bc90eba1cc1af048a055d319b522
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

<<<<<<< HEAD

    @PostMapping("/iniciarsesion")
    public  ResponseEntity<Integer>  iniciarSesion (@RequestBody LoginDTO loginDTO){
        Estudiante estudiante = estudianteService.iniciarSesion(loginDTO.email, loginDTO.contrasena);
        if(estudiante==null)
            return ResponseEntity.ok(0);
        return ResponseEntity.ok(estudiante.getIdEstudiante());
    }

=======
>>>>>>> 7d08b1608bf2bc90eba1cc1af048a055d319b522
    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }

}
