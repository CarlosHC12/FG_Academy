package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlumnoResponse(

        @Schema(description = "ID único del alumno", example = "23")
        int id,

        @Schema(description = "Nombre completo del alumno", example = "Juan Pérez")
        String nombre,

        @Schema(description = "Edad del alumno", example = "23")
        int edad,                       // ← Cambiado de 'precio' a 'edad'

        @Schema(description = "Fecha y hora de creación del registro", example = "2024-05-20T14:30:00")
        LocalDateTime createdAt,

        @Schema(description = "ID del profesor asociado", example = "1")
        int profesorId
) {
}