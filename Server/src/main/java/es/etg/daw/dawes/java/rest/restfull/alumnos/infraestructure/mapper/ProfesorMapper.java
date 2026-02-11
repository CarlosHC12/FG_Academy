package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorResponse;

public class ProfesorMapper {

    // ---------- Métodos para Command y DTO (ya existentes) ----------
    public static CreateProfesorCommand toCommand(ProfesorRequest profesorRequest) {
        return new CreateProfesorCommand(profesorRequest.nombre());
    }

    public static EditProfesorCommand toCommand(int id, ProfesorRequest profesorRequest) {
        return new EditProfesorCommand(new ProfesorId(id), profesorRequest.nombre());
    }

    public static ProfesorResponse toResponse(Profesor profesor) {
        return new ProfesorResponse(
            profesor.getId().getValue(),
            profesor.getNombre(),
            profesor.getCreatedAt()
        );
    }

    // ---------- Métodos para convertir con ProfesorEntity (NUEVOS) ----------
    public static Profesor toDomain(ProfesorEntity entity) {
        if (entity == null) return null;
        return Profesor.builder()
                .id(new ProfesorId(entity.getId()))
                .nombre(entity.getNombre())
                .build();
    }

    public static List<Profesor> toDomain(List<ProfesorEntity> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .map(ProfesorMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static ProfesorEntity toEntity(Profesor domain) {
        if (domain == null) return null;
        ProfesorEntity entity = new ProfesorEntity();
        entity.setId(domain.getId().getValue());
        entity.setNombre(domain.getNombre());
        return entity;
    }
}