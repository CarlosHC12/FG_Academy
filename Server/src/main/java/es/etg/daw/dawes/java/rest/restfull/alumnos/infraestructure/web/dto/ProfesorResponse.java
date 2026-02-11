package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto;

import java.time.LocalDateTime;

public record ProfesorResponse(
        int id,
        String nombre,
        LocalDateTime createdAt) {
}
