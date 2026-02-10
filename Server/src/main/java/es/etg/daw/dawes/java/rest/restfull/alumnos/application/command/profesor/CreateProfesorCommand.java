package es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateProfesorCommand {
    private final String nombre;
}

