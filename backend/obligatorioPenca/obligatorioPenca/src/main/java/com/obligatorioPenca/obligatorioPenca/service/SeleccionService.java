package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.Seleccion;
import com.obligatorioPenca.obligatorioPenca.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeleccionService {
    private final SeleccionRepository seleccionRepository;
    private final PrediccionService prediccionesService;

    @Autowired
    public SeleccionService(SeleccionRepository seleccionRepository, PrediccionService prediccionesService) {
        this.seleccionRepository = seleccionRepository;
        this.prediccionesService = prediccionesService;
    }

    public List<Seleccion> getSelecciones() {
        //List<Seleccion> selecciones = seleccionRepository.findAll();
        List<Seleccion> selecciones = seleccionRepository.getSelecciones();
        System.out.println("Selecciones: " + selecciones);
        return selecciones;
    }

    public Seleccion getSeleccionByNombre(String nombre) {
        Seleccion seleccion = seleccionRepository.getSeleccionByNombre(nombre);
        System.out.println("Seleccion: " + seleccion);
        return seleccion;
    }

    public void actualizarSeleccion(Seleccion seleccion) {
        prediccionesService.actualizarPuntaje();
        seleccionRepository.actualizarSeleccion(seleccion.getNombre(),seleccion.getEstado());
    }
}