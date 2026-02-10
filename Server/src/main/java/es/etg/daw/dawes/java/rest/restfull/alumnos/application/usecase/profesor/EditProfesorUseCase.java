package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.error.ProfesorNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditProfesorUseCase {
    private final ProfesorRepository profesorRepository;

    public Profesor update(EditProfesorCommand command) {
        return profesorRepository.getById(command.id())
                .map(p -> {
                    p.setNombre(command.nombre());
                    return profesorRepository.save(p);
                })
                .orElseThrow(() -> new ProfesorNotFoundException(command.id().getValue()));
    }
}
