package com.obligatorioPenca.obligatorioPenca.partido;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/partido")
public class PartidoController {
    @Autowired
    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

/*
    @GetMapping
    public List<Partido> getPartidos() {
        return partidoService.getpartidos();
    }
    */
@GetMapping
@ApiOperation(value = "Obtiene todos los partidos", response = PartidoDTO.class, responseContainer = "List")
public ResponseEntity<List<PartidoDTO>> getAllPartidos() {
    List<PartidoDTO> partidosDTO = partidoService.getPartidosDTO();
    return ResponseEntity.ok(partidosDTO);
}

    @PostMapping
    public void createPartido(@RequestBody  Partido partido ){

        partidoService.createpartido(partido);
    }
}
