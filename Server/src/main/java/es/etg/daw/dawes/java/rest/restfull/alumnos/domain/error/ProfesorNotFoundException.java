package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.error;

import es.etg.daw.dawes.java.rest.restfull.common.domain.error.EntityNotFoundException;

public class ProfesorNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "profesor";

    public ProfesorNotFoundException() {
        super(ENTIDAD);
    }

    public ProfesorNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}
