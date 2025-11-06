package com.soporte.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Tecnico {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad; // REDES, SOFTWARE, HARDWARE, BASE_DATOS

    private Boolean disponible;

    // Constructores
    public Tecnico() {
        this.disponible = true;
    }

    public Tecnico(String nombre, String email, String especialidad) {
        this();
        this.nombre = nombre;
        this.email = email;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}