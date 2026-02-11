package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorResponse;

public class ProfesorMapper {

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
}

