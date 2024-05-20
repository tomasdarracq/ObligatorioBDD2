package com.obligatorioPenca.obligatorioPenca.seleccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/seleccion")
@CrossOrigin(origins = "http://localhost:4200")
public class SeleccionController {
    private final SeleccionService seleccionService;

    @Autowired
    public SeleccionController(SeleccionService seleccionService) {
        this.seleccionService = seleccionService;
    }

    @GetMapping
    public List<Seleccion> getSelecciones() {
        return seleccionService.getSelecciones();
    }

    @GetMapping("/id/{idSeleccion}")
    public Seleccion getSeleccionById(@PathVariable int idSeleccion) {
        return seleccionService.getSeleccionById(idSeleccion);
    }
}
