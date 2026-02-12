package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Profesor {
    private ProfesorId id;
    private String nombre;
    private LocalDateTime createdAt;
}