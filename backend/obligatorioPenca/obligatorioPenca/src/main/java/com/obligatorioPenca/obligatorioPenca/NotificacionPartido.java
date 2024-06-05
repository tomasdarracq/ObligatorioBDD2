package com.obligatorioPenca.obligatorioPenca;

import com.obligatorioPenca.obligatorioPenca.estudiante.Estudiante;
import com.obligatorioPenca.obligatorioPenca.estudiante.EstudianteService;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoDTO;
import com.obligatorioPenca.obligatorioPenca.partido.PartidoService;
import com.obligatorioPenca.obligatorioPenca.prediccion.PrediccionDTO;
import com.obligatorioPenca.obligatorioPenca.prediccion.PrediccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
public class NotificacionPartido {
    @Autowired
    public PrediccionService prediccionService;
    @Autowired
    public EstudianteService estudianteService;
    @Autowired
    public PartidoService partidoService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(fixedRate = 36000)
    public void enviarMailPrediccion() {
        LocalDateTime fechaActual = LocalDateTime.now();
        List<PartidoDTO> partidos = partidoService.obtenerPartidosDTO();
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();

        for (PartidoDTO partidoDTO : partidos) {
            Duration duracion = Duration.between(fechaActual, partidoDTO.getFecha());
            if (duracion.toHours() == 1 && duracion.toMinutes() <= 60) { // avisar una hora antes del partido
                for (Estudiante estudiante : estudiantes) {
                    if (!tienePrediccion(estudiante, partidoDTO)) {
                        enviarCorreoNotificacion(partidoDTO, estudiante);
                    }
                }
            }
        }
    }

    private boolean tienePrediccion(Estudiante estudiante, PartidoDTO partidoDTO) {
        List<PrediccionDTO> predicciones = prediccionService.getPrediccionByIdEstudiante(estudiante.getIdEstudiante());
        for (PrediccionDTO prediccionDTO : predicciones) {
            if (prediccionDTO.getNombreSeleccionLocal().equals(partidoDTO.getSeleccionLocalNombre())
                    && prediccionDTO.getNombreSeleccionVisitante().equals(partidoDTO.getSeleccionVisitanteNombre())
                    && prediccionDTO.getFechaPartido().isEqual(partidoDTO.getFecha())
                    && prediccionDTO.getIdEstudiante() == estudiante.getIdEstudiante()) {
                return true;
            }
        }
        return false;
    }

    private void enviarCorreoNotificacion(PartidoDTO partidoDTO, Estudiante estudiante) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(estudiante.getEmail());
        mensaje.setSubject("Recordatorio de Prediccion");
        mensaje.setText("Hola " + estudiante.getNombre() + ",\n\nRecuerda completar tu prediccion en el partido "
                + partidoDTO.getSeleccionLocalNombre() + " VS " + partidoDTO.getSeleccionVisitanteNombre() + " que comienza en una hora.");

        javaMailSender.send(mensaje);
    }
}
