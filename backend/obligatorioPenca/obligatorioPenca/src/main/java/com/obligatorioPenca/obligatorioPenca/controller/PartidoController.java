package com.obligatorioPenca.obligatorioPenca.controller;

import com.obligatorioPenca.obligatorioPenca.model.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.service.PartidoService;
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
    public ResponseEntity<Boolean> agregarGoles(@RequestBody PartidoDTO partidoDTO){
        boolean result=false;
        if (partidoService.agregargoles(partidoDTO)!=null){
            result=true;
        }
        return ResponseEntity.ok(result);
    }




}
