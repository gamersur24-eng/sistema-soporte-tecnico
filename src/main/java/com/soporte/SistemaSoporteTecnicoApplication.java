package com.soporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaSoporteTecnicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaSoporteTecnicoApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("API de Soporte Técnico iniciada correctamente");
        System.out.println("URL: http://localhost:8080");
        System.out.println("Documentación Swagger: http://localhost:8080/swagger-ui.html");
        System.out.println("========================================\n");
    }
}