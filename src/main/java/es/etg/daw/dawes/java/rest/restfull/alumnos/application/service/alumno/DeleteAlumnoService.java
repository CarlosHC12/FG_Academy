package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteAlumnoService {

    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    public void delete(AlumnoId id) {
        deleteAlumnoUseCase.delete(id);
    }
}