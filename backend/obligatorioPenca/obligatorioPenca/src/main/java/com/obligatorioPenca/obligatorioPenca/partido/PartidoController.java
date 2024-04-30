package com.obligatorioPenca.obligatorioPenca.partido;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/partido")
public class PartidoController {

    @GetMapping
    public String getPartidos() {
        return "partido";
    }
}
