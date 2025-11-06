package com.soporte.service;

import com.soporte.exception.ResourceNotFoundException;
import com.soporte.model.Solicitud;
import com.soporte.model.Tecnico;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

    private final Map<Long, Solicitud> solicitudesDB = new HashMap<>();
    private final Map<Long, Tecnico> tecnicosDB = new HashMap<>();
    private final AtomicLong solicitudIdCounter = new AtomicLong(1);
    private final AtomicLong tecnicoIdCounter = new AtomicLong(1);

    public SolicitudServiceImpl() {
        inicializarTecnicos();
    }

    private void inicializarTecnicos() {
        Tecnico tecnico1 = new Tecnico("Juan Pérez", "juan@tech.com", "REDES");
        tecnico1.setId(tecnicoIdCounter.getAndIncrement());
        tecnicosDB.put(tecnico1.getId(), tecnico1);

        Tecnico tecnico2 = new Tecnico("María López", "maria@tech.com", "SOFTWARE");
        tecnico2.setId(tecnicoIdCounter.getAndIncrement());
        tecnicosDB.put(tecnico2.getId(), tecnico2);

        Tecnico tecnico3 = new Tecnico("Carlos Ruiz", "carlos@tech.com", "HARDWARE");
        tecnico3.setId(tecnicoIdCounter.getAndIncrement());
        tecnicosDB.put(tecnico3.getId(), tecnico3);
    }

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        Long id = solicitudIdCounter.getAndIncrement();
        solicitud.setId(id);
        solicitudesDB.put(id, solicitud);
        return solicitud;
    }

    @Override
    public List<Solicitud> obtenerTodasLasSolicitudes() {
        return new ArrayList<>(solicitudesDB.values());
    }

    @Override
    public Optional<Solicitud> obtenerSolicitudPorId(Long id) {
        return Optional.ofNullable(solicitudesDB.get(id));
    }

    @Override
    public Solicitud actualizarSolicitud(Long id, Solicitud solicitudActualizada) {
        Solicitud solicitud = solicitudesDB.get(id);
        if (solicitud == null) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + id);
        }

        solicitud.setDescripcion(solicitudActualizada.getDescripcion());
        solicitud.setPrioridad(solicitudActualizada.getPrioridad());
        solicitud.setEstado(solicitudActualizada.getEstado());

        if (solicitudActualizada.getCliente() != null) {
            solicitud.setCliente(solicitudActualizada.getCliente());
        }

        solicitudesDB.put(id, solicitud);
        return solicitud;
    }

    @Override
    public void eliminarSolicitud(Long id) {
        if (!solicitudesDB.containsKey(id)) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + id);
        }
        solicitudesDB.remove(id);
    }

    @Override
    public List<Solicitud> obtenerSolicitudesPorEstado(String estado) {
        return solicitudesDB.values().stream()
                .filter(s -> s.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    @Override
    public List<Solicitud> obtenerSolicitudesPorPrioridad(String prioridad) {
        return solicitudesDB.values().stream()
                .filter(s -> s.getPrioridad().equalsIgnoreCase(prioridad))
                .collect(Collectors.toList());
    }

    @Override
    public Solicitud asignarTecnico(Long solicitudId, Long tecnicoId) {
        Solicitud solicitud = solicitudesDB.get(solicitudId);
        if (solicitud == null) {
            throw new ResourceNotFoundException("Solicitud no encontrada con ID: " + solicitudId);
        }

        Tecnico tecnico = tecnicosDB.get(tecnicoId);
        if (tecnico == null) {
            throw new ResourceNotFoundException("Técnico no encontrado con ID: " + tecnicoId);
        }

        solicitud.setTecnicoAsignado(tecnico);
        solicitud.setEstado("EN_PROCESO");
        solicitudesDB.put(solicitudId, solicitud);

        return solicitud;
    }

    public List<Tecnico> obtenerTodosTecnicos() {
        return new ArrayList<>(tecnicosDB.values());
    }
}