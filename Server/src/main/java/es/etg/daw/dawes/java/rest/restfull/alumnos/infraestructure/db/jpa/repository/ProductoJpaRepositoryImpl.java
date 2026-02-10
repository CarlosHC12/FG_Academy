package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.ProductoEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductoJpaRepositoryImpl implements ProductoRepository{

    private final ProductoEntityJpaRepository repository;

    @Override
public Alumno save(Alumno t) {
    ProductoEntity prod = ProductoMapper.toEntity(t);
    ProductoEntity savedEntity = repository.save(prod); // savedEntity tiene el ID generado
    return ProductoMapper.toDomain(savedEntity); // Debe mapear el ID
}

    @Override
    public List<Alumno> getAll() {
        return ProductoMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        Optional<Alumno> producto = null;
        Optional<ProductoEntity> pe = repository.findById(id.getValue());

        if(pe.isEmpty()){
            producto = Optional.empty();
        }else{
            producto = Optional.of(ProductoMapper.toDomain(pe.get()));
        }

        return producto;
    }


    @Override
    public void deleteById(AlumnoId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

    @Override
    public Optional<Alumno> getByName(String name) {
        ProductoEntity prod = repository.findByNombre(name);
        if(prod!=null)
            return Optional.of(ProductoMapper.toDomain(prod));
        else
            return Optional.empty() ;
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.
}