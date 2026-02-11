package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;

public class ProfesorFactory {

    public static final Map<ProfesorId, Profesor> getDemoData() {
        Map<ProfesorId, Profesor> datos = new LinkedHashMap<>();

        datos.put(new ProfesorId(1), new Profesor(new ProfesorId(1), "Profesor 1", LocalDateTime.now()));
        datos.put(new ProfesorId(2), new Profesor(new ProfesorId(2), "Profesor 2", LocalDateTime.now()));
        return datos;
    }

    public static Profesor create() {
        return new Profesor(null, "Nuevo profesor", LocalDateTime.now());
    }
}