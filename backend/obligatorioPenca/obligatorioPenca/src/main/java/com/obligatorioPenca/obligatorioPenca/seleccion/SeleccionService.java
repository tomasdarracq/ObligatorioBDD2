package com.obligatorioPenca.obligatorioPenca.seleccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeleccionService {
    private final SeleccionRepository seleccionRepository;

    @Autowired
    public SeleccionService(SeleccionRepository seleccionRepository) {
        this.seleccionRepository = seleccionRepository;
    }

    public List<Seleccion> getSelecciones() {
        List<Seleccion> selecciones = seleccionRepository.getSelecciones();
        System.out.println("Selecciones: " + selecciones);
        return selecciones;
    }

    public Seleccion getSeleccionById(int idSeleccion) {
        Seleccion seleccion = seleccionRepository.getSeleccionById(idSeleccion);
        System.out.println("Seleccion: " + seleccion);
        return seleccion;
    }
}
