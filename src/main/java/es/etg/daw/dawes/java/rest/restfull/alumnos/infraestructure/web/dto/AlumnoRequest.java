package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.validation.NombradoAlumno;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AlumnoRequest(
        @NotBlank(message = "{alumno.valid.nombre.no_vacio}")
        @NombradoAlumno(message = "{alumno.valid.nombre.nombrado_validation}")
        String nombre,

        @Min(value = 0, message = "{alumno.valid.edad.min}")
        @Max(value = 100, message = "{alumno.valid.edad.max}")
        int edad,                       // ← Cambiado de 'precio' a 'edad'

        int profesorId) {

    public AlumnoRequest(Alumno a) {
        this(a.getNombre(), a.getEdad(), a.getProfesorId().getValue());
    }
}
