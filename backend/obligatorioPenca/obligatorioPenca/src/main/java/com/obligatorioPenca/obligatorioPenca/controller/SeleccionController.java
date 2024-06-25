package com.obligatorioPenca.obligatorioPenca.controller;

import com.obligatorioPenca.obligatorioPenca.model.Seleccion;
import com.obligatorioPenca.obligatorioPenca.service.SeleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{nombre}")
    public Seleccion getSeleccionByNombre(@PathVariable String nombre) {
        return seleccionService.getSeleccionByNombre(nombre);
    }
    @PutMapping()
    public void actualizarSeleccion(@RequestBody Seleccion seleccion) {
        seleccionService.actualizarSeleccion(seleccion);
    }
}
