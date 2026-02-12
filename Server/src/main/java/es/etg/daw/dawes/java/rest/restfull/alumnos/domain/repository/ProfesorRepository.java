package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.common.domain.repository.CRUDRepository;

public interface ProfesorRepository extends CRUDRepository<Profesor, ProfesorId> {

    Optional<Profesor> getByNombre(String nombre);

}