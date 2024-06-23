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
        return ResponseEntity.ok(partidosDTO);//ResponseEntity.ok().body(partidosDTO)
    }

    @PostMapping("/fecha")
    public ResponseEntity<List<PartidoDTO>> obtenerPartidoByFecha(@RequestBody LocalDateTime fecha){
        List<PartidoDTO> partidosDTO=partidoService.obtenerPartidoByFecha(fecha);
        return ResponseEntity.ok(partidosDTO);
    }

    @PostMapping
    public ResponseEntity<PartidoDTO> createPartido(@RequestBody  PartidoDTO partido ){
        partidoService.crearPartido(partido);
        return  ResponseEntity.ok(partido);

    }

    @PutMapping
    public ResponseEntity<Integer> agregarGoles(@RequestBody PartidoDTO partidoDTO){
        System.out.println(partidoDTO.getSeleccionLocalNombre());
        System.out.println(partidoDTO.getSeleccionVisitanteNombre());
        System.out.println(partidoDTO.getFecha());
        System.out.println(partidoDTO.getGolesLocal());
        System.out.println(partidoDTO.getGolesVisitante());

        return ResponseEntity.ok(partidoService.agregarGoles(partidoDTO));
    }


}
