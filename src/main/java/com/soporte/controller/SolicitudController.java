package com.soporte.controller;

import com.soporte.model.Solicitud;
import com.soporte.model.Tecnico;
import com.soporte.service.SolicitudServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "*")
public class SolicitudController {

    @Autowired
    private SolicitudServiceImpl solicitudService;

    /**
     * Crear una nueva solicitud de soporte
     * POST /api/solicitudes
     */
    @PostMapping
    public ResponseEntity<Solicitud> crearSolicitud(@Valid @RequestBody Solicitud solicitud) {
        Solicitud nuevaSolicitud = solicitudService.crearSolicitud(solicitud);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
    }

    /**
     * Obtener todas las solicitudes
     * GET /api/solicitudes
     */
    @GetMapping
    public ResponseEntity<List<Solicitud>> obtenerTodasLasSolicitudes() {
        List<Solicitud> solicitudes = solicitudService.obtenerTodasLasSolicitudes();
        return ResponseEntity.ok(solicitudes);
    }

    /**
     * Obtener una solicitud por ID
     * GET /api/solicitudes/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtenerSolicitudPorId(@PathVariable Long id) {
        return solicitudService.obtenerSolicitudPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualizar una solicitud existente
     * PUT /api/solicitudes/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizarSolicitud(
            @PathVariable Long id,
            @Valid @RequestBody Solicitud solicitud) {
        Solicitud solicitudActualizada = solicitudService.actualizarSolicitud(id, solicitud);
        return ResponseEntity.ok(solicitudActualizada);
    }

    /**
     * Eliminar una solicitud
     * DELETE /api/solicitudes/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminarSolicitud(id);
        return ResponseEntity.ok(Map.of("mensaje", "Solicitud eliminada exitosamente"));
    }

    /**
     * Obtener solicitudes por estado
     * GET /api/solicitudes/estado/{estado}
     */
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Solicitud>> obtenerSolicitudesPorEstado(@PathVariable String estado) {
        List<Solicitud> solicitudes = solicitudService.obtenerSolicitudesPorEstado(estado);
        return ResponseEntity.ok(solicitudes);
    }

    /**
     * Obtener solicitudes por prioridad
     * GET /api/solicitudes/prioridad/{prioridad}
     */
    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<Solicitud>> obtenerSolicitudesPorPrioridad(@PathVariable String prioridad) {
        List<Solicitud> solicitudes = solicitudService.obtenerSolicitudesPorPrioridad(prioridad);
        return ResponseEntity.ok(solicitudes);
    }

    /**
     * Asignar un técnico a una solicitud
     * PATCH /api/solicitudes/{solicitudId}/asignar/{tecnicoId}
     */
    @PatchMapping("/{solicitudId}/asignar/{tecnicoId}")
    public ResponseEntity<Solicitud> asignarTecnico(
            @PathVariable Long solicitudId,
            @PathVariable Long tecnicoId) {
        Solicitud solicitud = solicitudService.asignarTecnico(solicitudId, tecnicoId);
        return ResponseEntity.ok(solicitud);
    }

    /**
     * Obtener todos los técnicos disponibles
     * GET /api/solicitudes/tecnicos
     */
    @GetMapping("/tecnicos")
    public ResponseEntity<List<Tecnico>> obtenerTodosTecnicos() {
        List<Tecnico> tecnicos = solicitudService.obtenerTodosTecnicos();
        return ResponseEntity.ok(tecnicos);
    }
}