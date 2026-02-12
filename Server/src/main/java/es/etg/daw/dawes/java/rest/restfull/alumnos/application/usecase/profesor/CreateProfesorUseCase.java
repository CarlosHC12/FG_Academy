package es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProfesorUseCase {

    private final ProfesorRepository profesorRepository;

    public Profesor create(CreateProfesorCommand comando) {

        Profesor profesor = Profesor.builder()
                .nombre(comando.nombre())
                .createdAt(LocalDateTime.now())
                .build();

        // IMPORTANTE: Devolver el resultado del save (con ID generado)
        return profesorRepository.save(profesor);
    }
}