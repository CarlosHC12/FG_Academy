package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoService {
    
    private final FindAlumnoUseCase findAlumnoUseCase;


     public List<Alumno> findAll() {
        return findAlumnoUseCase.findAll();
     }
    
}