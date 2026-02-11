package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository.AlumnoEntityJpaRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.repository.mock.AlumnoFactory;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.AlumnoMapper;

@DataJpaTest(showSql = true)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlumnoEntityJpaRepositoryTest {

    @Autowired
    private AlumnoEntityJpaRepository repository;

    @Test
    @Order(1)
    void findAll() {
        var alumnos = repository.findAll();

        assertAll(
                () -> assertNotNull(alumnos),
                () -> assertTrue(!alumnos.isEmpty())
        );
    }

    @Test
    @Order(2)
    void findById() {
        // Actualizamos para tener un alumno controlado
        var alumnoGuardado = updateAndGet();

        var alumnoEncontrado = repository
                .findById(alumnoGuardado.getId())
                .orElseThrow();

        assertAll(
                () -> assertNotNull(alumnoEncontrado),
                () -> assertEquals(alumnoGuardado.getId(), alumnoEncontrado.getId()),
                () -> assertEquals(alumnoGuardado.getNombre(), alumnoEncontrado.getNombre()),
                () -> assertEquals(alumnoGuardado.getEdad(), alumnoEncontrado.getEdad())
        );
    }

    @Test
    @Order(3)
    void findByNombre() {
        var alumnoGuardado = updateAndGet();

        var alumnoEncontrado = repository.findByNombre(alumnoGuardado.getNombre());

        assertAll(
                () -> assertNotNull(alumnoEncontrado),
                () -> assertEquals(alumnoGuardado.getId(), alumnoEncontrado.getId()),
                () -> assertEquals(alumnoGuardado.getNombre(), alumnoEncontrado.getNombre()),
                () -> assertEquals(alumnoGuardado.getEdad(), alumnoEncontrado.getEdad())
        );
    }

    @Test
    @Order(5)
    void create() {
        var nuevoAlumno = AlumnoMapper.toEntity(AlumnoFactory.create());
        nuevoAlumno.setId(null); // Forzar generación de ID
        var alumnoGuardado = repository.save(nuevoAlumno);

        assertAll(
                () -> assertNotNull(alumnoGuardado),
                () -> assertNotNull(alumnoGuardado.getId())
        );
    }

    /**
     * Método auxiliar que guarda un alumno de prueba y lo devuelve.
     * Se usa en los tests que necesitan un alumno existente.
     */
    private AlumnoEntity updateAndGet() {
        var nuevoAlumno = AlumnoMapper.toEntity(AlumnoFactory.create());
        nuevoAlumno.setId(null);
        return repository.save(nuevoAlumno);
    }

    @Test
    @Order(15)
    void delete() {
        // Creamos un alumno y lo eliminamos
        var alumnoGuardado = updateAndGet();
        Long idAEliminar = alumnoGuardado.getId();

        repository.delete(alumnoGuardado);

        var alumnoEliminado = repository.findById(idAEliminar);
        assertTrue(alumnoEliminado.isEmpty());
    }
}