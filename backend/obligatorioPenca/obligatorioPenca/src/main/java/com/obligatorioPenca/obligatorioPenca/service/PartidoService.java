package com.obligatorioPenca.obligatorioPenca.service;

import com.obligatorioPenca.obligatorioPenca.model.Partido;
import com.obligatorioPenca.obligatorioPenca.model.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public PartidoDTO crearpartido(PartidoDTO partidoDTO) {
        partidoRepository.insertarPartido(
                partidoDTO.getSeleccionLocalNombre(),
                partidoDTO.getSeleccionVisitanteNombre(),
                partidoDTO.getFecha(),
                partidoDTO.getGolesLocal(),
                partidoDTO.getGolesVisitante()
        );
        return partidoDTO;
    }

    public List<PartidoDTO> obtenerPartidosDTO() {
        List<Partido> partidos = partidoRepository.findAllPartidos();
        List<PartidoDTO> partidosDTO = new ArrayList<>();

        for (Partido partido : partidos) {
            PartidoDTO partidoDTO = new PartidoDTO(
                    partido.getSeleccionlocal().getNombre(),
                    partido.getSeleccionvisitante().getNombre(),
                    partido.getGolLocal(),
                    partido.getGolVisitante(),

                    partido.getId().getFecha()
            );
            partidosDTO.add(partidoDTO);
        }
        return partidosDTO;
    }

    public List<PartidoDTO> obtnerPartidoByFecha(LocalDateTime fecha){
        List<Partido> partidos= partidoRepository.findAllbyFecha(fecha);
        List<PartidoDTO> partidosDTO = new ArrayList<>();

        for (Partido partido : partidos) {
            PartidoDTO partidoDTO = new PartidoDTO(
                    partido.getSeleccionlocal().getNombre(),
                    partido.getSeleccionvisitante().getNombre(),
                    partido.getGolLocal(),
                    partido.getGolVisitante(),
                    partido.getId().getFecha()
            );
            partidosDTO.add(partidoDTO);
        }
        return partidosDTO;
    }

    public String agregargoles(PartidoDTO partidoDTO){
    partidoRepository.actualizarGolesPartido(partidoDTO.getSeleccionLocalNombre(),
            partidoDTO.getSeleccionVisitanteNombre(),
            partidoDTO.getFecha(),
            partidoDTO.getGolesLocal(),
            partidoDTO.getGolesVisitante());
    return "El partido se guardo correctamente";

    }
    
}

