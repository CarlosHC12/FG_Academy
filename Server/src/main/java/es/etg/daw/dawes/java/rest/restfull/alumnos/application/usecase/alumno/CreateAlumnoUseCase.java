package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public Alumno create(CreateAlumnoCommand comando) {
        // Se puede usar comando.nombre() y no getNombre() por usar @Accessors(fluent = true)
        // en la clase CreateAlumnoCommand

        Alumno alumno = Alumno.builder()
                .nombre(comando.nombre())
                .edad(comando.edad())
                .profesorId(comando.profesorId()) // Cambiado de .profesor() a .profesorId()
                .createdAt(LocalDateTime.now())
                .build();

        return alumnoRepository.save(alumno);
    }
}
