package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.AlumnoRepository;

@Repository
public class AlumnoRepositoryMockImpl implements AlumnoRepository {

    private final Map<AlumnoId, Alumno> alumnos = AlumnoFactory.getDemoData();

    @Override
    public Alumno save(Alumno t) {
        // create
        if (t.getId() == null) t.setId(new AlumnoId(obtenerSiguienteId()));

        alumnos.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        AlumnoId ultimo = new AlumnoId(0);
        if (!alumnos.isEmpty()) {
            Collection<Alumno> lista = alumnos.values();
            for (Alumno p : lista) {
                ultimo = p.getId();
            }
        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Alumno> getAll() {
        return new ArrayList<>(alumnos.values());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        return Optional.ofNullable(alumnos.get(id));
    }

    @Override
    public void deleteById(AlumnoId id) {
        alumnos.remove(id);
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO: Implementar búsqueda por nombre si es necesario
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
}