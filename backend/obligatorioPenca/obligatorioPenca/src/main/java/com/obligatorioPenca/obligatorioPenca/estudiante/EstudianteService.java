package com.obligatorioPenca.obligatorioPenca.estudiante;

import com.obligatorioPenca.obligatorioPenca.partido.Partido;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {
    private final PartidoRepository partidoRepository;

    public EstudianteService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public PartidoDTO createpartido(PartidoDTO partidoDTO) {
        partidoRepository.insertarPartido(
                partidoDTO.getSeleccionLocalNombre(),
                partidoDTO.getSeleccionVisitanteNombre(),
                partidoDTO.getFecha(),
                partidoDTO.getGolesLocal(),
                partidoDTO.getGolesVisitante()
        );
        return partidoDTO;
    }

    public List<PartidoDTO> getPartidosDTO() {
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

    public List<PartidoDTO> getPartidobyFecha(LocalDateTime fecha){
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
}

