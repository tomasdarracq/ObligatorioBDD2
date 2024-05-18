package com.obligatorioPenca.obligatorioPenca.partido;

import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping
    public List<Partido> getPartidos() {
        return partidoService.getpartidos();
    }

    @PostMapping
    public void createPartido(@RequestBody  Partido partido ){
        partidoService.createpartido(partido);
    }
}
