package es.etg.daw.dawes.java.rest.restfull;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.dawes.java.rest.restfull.thym.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.thym.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.thym.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.db.repository.mock.ProductoFactory;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.db.repository.mock.ProductoRepositoryMockImpl;

public class ProductoRepositoryMockImplTest {

    ProductoRepository repository;

    @BeforeEach
    void setUp() {
        // Inicializamos las el repositorio
        repository = new ProductoRepositoryMockImpl();
    }

    @Test
    void save() {
        // Arrange
        var producto = ProductoFactory.create();
        // Act
        Alumno p = repository.save(producto);
        // Asset
        assertAll(
                () -> assertNotNull(p), // el producto no es nulo
                () -> assertNotNull(p.getId()), // el producto creado tiene id
                () -> assertNotNull(repository.getById(p.getId())) // si lo busco lo debo recuperar *opcional
        );

    }

    @Test
    void getAll() {
        // Act
        var productos = repository.getAll();
        // Assert
        assertAll(
                () -> assertNotNull(productos),
                () -> assertEquals(ProductoFactory.getDemoData().size(), productos.size()));
    }

    @Test

    void getById() {
        // Arrange
        AlumnoId id = new AlumnoId(1);
        // Act
        Optional<Alumno> p = repository.getById(id);
        // Assert
        assertTrue(p.isPresent());
        assertEquals(id, p.get().getId());
    }

    
    @Test

    void deleteById() {
        // Arrange
        AlumnoId id = new AlumnoId(1);
        // Act
        repository.deleteById(id);
        // Assert
        assertAll(
                () -> assertTrue(repository.getById(id).isEmpty()));
    }

}
