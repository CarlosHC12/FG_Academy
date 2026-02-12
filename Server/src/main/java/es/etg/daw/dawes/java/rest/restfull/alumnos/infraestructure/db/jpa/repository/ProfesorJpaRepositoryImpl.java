package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.ProfesorMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfesorJpaRepositoryImpl implements ProfesorRepository {

    private final ProfesorEntityJpaRepository repository;

    @Override
    public Profesor save(Profesor profesor) {
        ProfesorEntity entity = ProfesorMapper.toEntity(profesor);
        ProfesorEntity savedEntity = repository.save(entity);
        return ProfesorMapper.toDomain(savedEntity);
    }

    @Override
    public List<Profesor> getAll() {
        return ProfesorMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Profesor> getById(ProfesorId id) {
        Optional<Profesor> profesor = Optional.empty();
        Optional<ProfesorEntity> pe = repository.findById(id.getValue());

        if (pe.isPresent()) {
            profesor = Optional.of(ProfesorMapper.toDomain(pe.get()));
        }

        return profesor;
    }

    @Override
    public void deleteById(ProfesorId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Profesor> getByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByNombre'");
    }

}