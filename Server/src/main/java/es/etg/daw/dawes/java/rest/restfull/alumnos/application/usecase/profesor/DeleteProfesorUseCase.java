package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProfesorUseCase {
    private final ProfesorRepository profesorRepository;

    public void delete(ProfesorId id) {
        profesorRepository.deleteById(id);
    }
}