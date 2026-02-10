package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;

@Repository
public class ProductoRepositoryMockImpl implements ProductoRepository {

    private final Map<AlumnoId, Alumno> productos = ProductoFactory.getDemoData();

    // Mejora para calcular el id de la creación que viene vacío
        @Override
    public Alumno save(Alumno t) {
            //create
        if(t.getId()==null) t.setId(new AlumnoId(obtenerSiguienteId()));

        productos.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId(){
        AlumnoId ultimo = new AlumnoId(0);
        if(!productos.isEmpty()){
            Collection<Alumno> lista = productos.values();
            
            for (Alumno p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo.getValue()+1;
    }

    @Override
    public List<Alumno> getAll() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        // Un optional puede tener una valor o no. Si no existe el producto devuelve
        // Optional.empty
        return Optional.ofNullable(productos.get(id));
    }

    @Override
    public void deleteById(AlumnoId id) {
        productos.remove(id);
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Sin implementar
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
