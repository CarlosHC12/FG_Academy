package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.ProfesorEntity;

@Repository
public interface ProfesorEntityJpaRepository extends JpaRepository<ProfesorEntity, Integer>{
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

    public ProfesorEntity findByNombre(String nombre);

    
}