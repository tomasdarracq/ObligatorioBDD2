package com.obligatorioPenca.obligatorioPenca.partido;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> getpartidos(){
        return partidoRepository.findAll();
    }

    public void createpartido(Partido partido){
        partidoRepository.save(partido);
    }


}
