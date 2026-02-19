package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlumnoJpaRepositoryImpl implements AlumnoRepository {

    private final AlumnoEntityJpaRepository repository;

    @Override
    public Alumno save(Alumno t) {
        AlumnoEntity entity = AlumnoMapper.toEntity(t);
        AlumnoEntity savedEntity = repository.save(entity); // savedEntity tiene el ID generado
        return AlumnoMapper.toDomain(savedEntity); // Debe mapear el ID
    }

    @Override
    public List<Alumno> getAll() {
        return AlumnoMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        Optional<Alumno> alumno = Optional.empty();
        Optional<AlumnoEntity> ae = repository.findById(id.getValue());

        if(ae.isPresent()){
            alumno = Optional.of(AlumnoMapper.toDomain(ae.get()));
        }

        return alumno;
    }

    @Override
    public void deleteById(AlumnoId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        AlumnoEntity entity = repository.findByNombre(name);
        if(entity != null)
            return Optional.of(AlumnoMapper.toDomain(entity));
        else
            return Optional.empty();
    }
}