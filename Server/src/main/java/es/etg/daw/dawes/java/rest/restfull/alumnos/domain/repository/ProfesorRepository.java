package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.common.domain.repository.CRUDRepository;

public interface ProfesorRepository extends CRUDRepository<Profesor, ProfesorId> {
    
}