package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.AlumnoEntity;

@Repository
public interface AlumnoEntityJpaRepository extends JpaRepository<AlumnoEntity, Integer>{
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

    public AlumnoEntity findByNombre(String nombre);
}