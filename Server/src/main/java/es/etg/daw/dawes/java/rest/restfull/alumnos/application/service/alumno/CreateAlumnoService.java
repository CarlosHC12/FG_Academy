package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAlumnoService {

    private final CreateAlumnoUseCase createAlumnoUseCase;

    public Alumno createAlumno(CreateAlumnoCommand comando) {
        Alumno alumno = createAlumnoUseCase.create(comando);
        return alumno;
    }
}