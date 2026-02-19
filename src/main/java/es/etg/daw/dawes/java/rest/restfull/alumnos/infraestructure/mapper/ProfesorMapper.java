package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorResponse;

public class ProfesorMapper {

    public static ProfesorEntity toEntity(Profesor p) {
        ProfesorEntity entity = ProfesorEntity.builder()
                .nombre(p.getNombre())
                .juego(p.getJuego())
                .build();

        if (p.getId() != null) {
            entity.setId(p.getId().getValue());
        }

        return entity;
    }

    public static CreateProfesorCommand toCommand(ProfesorRequest req) {
        return new CreateProfesorCommand(req.nombre(), req.juego());
    }

    public static EditProfesorCommand toCommand(int id, ProfesorRequest req) {
        return new EditProfesorCommand(new ProfesorId(id), req.nombre(), req.juego());
    }

    public static ProfesorResponse toResponse(Profesor p) {
        if (p.getId() == null) {
            throw new IllegalStateException("El ID del profesor no puede ser nulo");
        }
        return new ProfesorResponse(
                p.getId().getValue(),
                p.getNombre(),
                p.getJuego());
    }

    public static Profesor toDomain(ProfesorEntity p) {
        if (p.getId() == null) {
            throw new IllegalStateException("El ID de la entidad no puede ser nulo");
        }
        return Profesor.builder()
                .id(new ProfesorId(p.getId()))
                .nombre(p.getNombre())
                .juego(p.getJuego())
                .build();
    }

    public static List<Profesor> toDomain(List<ProfesorEntity> lista) {
        List<Profesor> lp = new ArrayList<>();
        for (ProfesorEntity pe : lista) {
            lp.add(toDomain(pe));
        }
        return lp;
    }
}