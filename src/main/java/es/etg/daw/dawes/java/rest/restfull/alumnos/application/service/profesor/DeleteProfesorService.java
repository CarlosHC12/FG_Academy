package es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.DeleteProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteProfesorService {
    private final DeleteProfesorUseCase deleteProfesorUseCase;

    public void delete(ProfesorId id){
        deleteProfesorUseCase.delete(id);
    }
}