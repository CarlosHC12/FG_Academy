package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;
    
    public Alumno update(EditAlumnoCommand command) {
        return alumnoRepository.getById(command.id())
                .map(p -> {
                    p.setNombre(command.nombre());
                    p.setEdad(command.edad());
                    p.setProfesorId(command.profesorId()); // Asumiendo que tienes este método setter
                    return alumnoRepository.save(p);
                })
                .orElseThrow(() -> new AlumnoNotFoundException(command.id().getValue()));
    }
}