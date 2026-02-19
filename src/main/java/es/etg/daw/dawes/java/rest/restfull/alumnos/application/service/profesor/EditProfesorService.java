package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.EditProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditProfesorService {
    private final EditProfesorUseCase editProfesorUseCase;

    public Profesor update(EditProfesorCommand editProfesorCommand) {
        return editProfesorUseCase.update(editProfesorCommand);
    }
}
