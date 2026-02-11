package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import jakarta.validation.constraints.NotBlank;

public record ProfesorRequest(
        @NotBlank(message = "{profesor.valid.nombre.no_vacio}") String nombre) {

    public ProfesorRequest(Profesor p) {
        this(p.getNombre());
    }
}
