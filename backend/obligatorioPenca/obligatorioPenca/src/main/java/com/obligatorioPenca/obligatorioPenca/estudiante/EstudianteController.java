package com.obligatorioPenca.obligatorioPenca.estudiante;

import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.prediccion.PrediccionService;
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

	@Autowired
	public EstudianteController(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}

	@GetMapping
	public List<Estudiante> obtenerTodosLosEstudiantes() {
		return estudianteService.obtenerTodosLosEstudiantes();
	}


}
