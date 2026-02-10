package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.AlumnoId;

public class ProductoFactory {

    public static final Map<AlumnoId, Alumno> getDemoData() {
        Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();

        datos.put(new AlumnoId(1),
                new Alumno(new AlumnoId(1), "Nombre producto 1", 1.01, LocalDateTime.now(), new ProfesorId(1)));
        datos.put(new AlumnoId(2),
                new Alumno(new AlumnoId(2), "Nombre producto 2", 1.02, LocalDateTime.now(), new ProfesorId(1)));
        datos.put(new AlumnoId(3),
                new Alumno(new AlumnoId(3), "Nombre producto 3", 1.03, LocalDateTime.now(), new ProfesorId(2)));
        datos.put(new AlumnoId(4),
                new Alumno(new AlumnoId(4), "Nombre producto 4", 1.04, LocalDateTime.now(), new ProfesorId(2)));

        return datos;
    }

    public static Alumno create() {
        return new Alumno(new AlumnoId(5), "Nuevo", 9.99, LocalDateTime.now(), new ProfesorId(1));
    }

}