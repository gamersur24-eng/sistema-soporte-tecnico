package com.soporte.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Solicitud {

    private Long id;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "La prioridad es obligatoria")
    private String prioridad; // ALTA, MEDIA, BAJA

    @NotBlank(message = "El estado es obligatorio")
    private String estado; // PENDIENTE, EN_PROCESO, RESUELTO, CERRADO

    @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;

    private Tecnico tecnicoAsignado;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    // Constructores
    public Solicitud() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }

    public Solicitud(String descripcion, String prioridad, Cliente cliente) {
        this();
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.cliente = cliente;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}