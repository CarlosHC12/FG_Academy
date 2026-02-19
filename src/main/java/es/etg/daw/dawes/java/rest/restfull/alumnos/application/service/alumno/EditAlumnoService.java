package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.EditAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditAlumnoService {

    private final EditAlumnoUseCase editAlumnoUseCase;

    public Alumno update(EditAlumnoCommand editAlumnoCommand) {
        return editAlumnoUseCase.update(editAlumnoCommand);
    }
}