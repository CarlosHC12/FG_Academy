package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;
    
    public void delete(AlumnoId id) {
        alumnoRepository.deleteById(id);
    }
}