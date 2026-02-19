package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.error;

import es.etg.daw.dawes.java.rest.restfull.common.domain.error.EntityNotFoundException;

public class AlumnoNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "alumno";

    public AlumnoNotFoundException() {
        super(ENTIDAD);
    }

    public AlumnoNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}