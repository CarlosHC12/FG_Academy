package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;

@Repository
public class ProfesorRepositoryMockImpl implements ProfesorRepository {

    private final Map<ProfesorId, Profesor> profesores = ProfesorFactory.getDemoData();

    @Override
    public Profesor save(Profesor t) {
        // create
        if (t.getId() == null) t.setId(new ProfesorId(obtenerSiguienteId()));

        profesores.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        ProfesorId ultimo = new ProfesorId(0);

        if (!profesores.isEmpty()) {
            Collection<Profesor> lista = profesores.values();
            for (Profesor c : lista) {
                ultimo = c.getId();
            }
        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Profesor> getAll() {
        return new ArrayList<>(profesores.values());
    }

    @Override
    public Optional<Profesor> getById(ProfesorId id) {
        return Optional.ofNullable(profesores.get(id));
    }

    @Override
    public void deleteById(ProfesorId id) {
        profesores.remove(id);
    }

    // Nota: No hay método getByName en ProfesorRepository, por lo que no se implementa.
}