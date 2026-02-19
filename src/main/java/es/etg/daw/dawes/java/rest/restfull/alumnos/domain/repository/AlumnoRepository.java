package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.common.domain.repository.CRUDRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;

public interface AlumnoRepository extends CRUDRepository<Alumno, AlumnoId> {
    
    Optional<Alumno> getByName(String nombre);
    
}
