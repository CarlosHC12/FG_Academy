package es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateAlumnoCommand {

    private final String nombre;
    private final int edad;
    private final ProfesorId profesorId;

    }
