package com.obligatorioPenca.obligatorioPenca.partido;

import com.obligatorioPenca.obligatorioPenca.estudiante.Estudiante;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<List<PartidoDTO>> getAllPartidos() {
        List<PartidoDTO> partidosDTO = partidoService.obtenerPartidosDTO();
        return ResponseEntity.ok(partidosDTO);
    }

    @PostMapping("/fecha")
    public ResponseEntity<List<PartidoDTO>> obtenerpartidobyFecha(@RequestBody LocalDateTime fecha){
        List<PartidoDTO> partidosDTO=partidoService.obtnerPartidoByFecha(fecha);
        return ResponseEntity.ok(partidosDTO);
    }

    @PostMapping
    public ResponseEntity<PartidoDTO> createPartido(@RequestBody  PartidoDTO partido ){
        partidoService.crearpartido(partido);
        return  ResponseEntity.ok(partido);

    }

    @PutMapping
    public ResponseEntity<String> agregarGoles(@RequestBody PartidoDTO partidoDTO){
        return ResponseEntity.ok(partidoService.agregargoles(partidoDTO));
    }


}
