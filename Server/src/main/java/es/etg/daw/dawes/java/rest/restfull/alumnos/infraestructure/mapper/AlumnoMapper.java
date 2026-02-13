package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.AlumnoResponse;

public class AlumnoMapper {

    public static AlumnoEntity toEntity(Alumno a) {
        ProfesorEntity profesor = new ProfesorEntity();
        profesor.setId(a.getProfesorId().getValue());

        AlumnoEntity entity = AlumnoEntity.builder()
                .nombre(a.getNombre())
                .edad(a.getEdad())
                .fechaCreacion(a.getCreatedAt() != null ? a.getCreatedAt() : LocalDateTime.now())
                .profesor(profesor)
                .build();

        if (a.getId() != null) {
            entity.setId(a.getId().getValue());
        }

        return entity;
    }

    public static CreateAlumnoCommand toCommand(AlumnoRequest req) {
        return new CreateAlumnoCommand(req.nombre(), req.edad(), new ProfesorId(req.profesorId()));
    }

    public static EditAlumnoCommand toCommand(int id, AlumnoRequest req) {
        return new EditAlumnoCommand(new AlumnoId(id), req.nombre(), req.edad(), new ProfesorId(req.profesorId()));
    }

    public static AlumnoResponse toResponse(Alumno a) {
        return new AlumnoResponse(
                a.getId().getValue(),
                a.getNombre(),
                a.getEdad(),
                a.getCreatedAt(),
                a.getProfesorId().getValue());
    }

    public static Alumno toDomain(AlumnoEntity a) {
        if (a.getId() == null) {
            throw new IllegalStateException("El ID de la entidad no puede ser nulo");
        }
        return Alumno.builder()
                .id(new AlumnoId(a.getId()))
                .nombre(a.getNombre())
                .edad(a.getEdad())
                .createdAt(a.getFechaCreacion())
                .profesorId(new ProfesorId(a.getProfesor().getId()))
                .build();
    }

    public static List<Alumno> toDomain(List<AlumnoEntity> lista) {
        List<Alumno> la = new ArrayList<>();
        for (AlumnoEntity ae : lista) {
            la.add(toDomain(ae));
        }
        return la;
    }
}