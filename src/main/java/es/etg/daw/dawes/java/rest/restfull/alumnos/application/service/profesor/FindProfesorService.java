package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.FindProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindProfesorService {
    private final FindProfesorUseCase findProfesorUseCase;

    public List<Profesor> findAll() {
        return findProfesorUseCase.findAll();
    }
}