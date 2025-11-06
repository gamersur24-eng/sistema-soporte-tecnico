package com.soporte.service;

import com.soporte.model.Solicitud;
import java.util.List;
import java.util.Optional;

public interface ISolicitudService {

    Solicitud crearSolicitud(Solicitud solicitud);

    List<Solicitud> obtenerTodasLasSolicitudes();

    Optional<Solicitud> obtenerSolicitudPorId(Long id);

    Solicitud actualizarSolicitud(Long id, Solicitud solicitud);

    void eliminarSolicitud(Long id);

    List<Solicitud> obtenerSolicitudesPorEstado(String estado);

    List<Solicitud> obtenerSolicitudesPorPrioridad(String prioridad);

    Solicitud asignarTecnico(Long solicitudId, Long tecnicoId);
}