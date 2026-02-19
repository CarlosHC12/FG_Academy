package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;

public class AlumnoFactory {

    public static final Map<AlumnoId, Alumno> getDemoData() {
        Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();

        datos.put(new AlumnoId(1),
                new Alumno(new AlumnoId(1), "Nombre alumno 1", 20, LocalDateTime.now(), new ProfesorId(1)));
        datos.put(new AlumnoId(2),
                new Alumno(new AlumnoId(2), "Nombre alumno 2", 21, LocalDateTime.now(), new ProfesorId(1)));
        datos.put(new AlumnoId(3),
                new Alumno(new AlumnoId(3), "Nombre alumno 3", 22, LocalDateTime.now(), new ProfesorId(2)));
        datos.put(new AlumnoId(4),
                new Alumno(new AlumnoId(4), "Nombre alumno 4", 23, LocalDateTime.now(), new ProfesorId(2)));

        return datos;
    }

    public static Alumno create() {
        return new Alumno(new AlumnoId(5), "Nuevo alumno", 24, LocalDateTime.now(), new ProfesorId(5));
    }
}