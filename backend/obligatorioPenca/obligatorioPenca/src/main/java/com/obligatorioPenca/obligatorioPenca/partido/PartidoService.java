package com.obligatorioPenca.obligatorioPenca.partido;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> getpartidos() {
        return partidoRepository.findAllPartidos();
    }

    public void createpartido(Partido partido) {
        partidoRepository.save(partido);
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
}

