package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.CreateProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateProfesorService {
    private final CreateProfesorUseCase createProfesorUseCase;

    public Profesor createProfesor(CreateProfesorCommand comando){
        Profesor profesor = createProfesorUseCase.create(comando);
        return profesor;
    }
}

