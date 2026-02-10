package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor;

import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.error.ProfesorNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindProfesorUseCase {
    private final ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        List<Profesor> profesores = profesorRepository.getAll();
        if (profesores.isEmpty())
            throw new ProfesorNotFoundException();
        return profesores;
    }
}