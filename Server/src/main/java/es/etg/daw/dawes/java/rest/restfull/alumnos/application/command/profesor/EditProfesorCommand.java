package es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditProfesorCommand {
    
    private final ProfesorId id;
    private final String nombre;
}


