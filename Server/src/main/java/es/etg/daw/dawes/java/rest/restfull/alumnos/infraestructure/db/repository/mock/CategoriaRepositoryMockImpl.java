package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;

@Repository
public class CategoriaRepositoryMockImpl implements CategoriaRepository {

    private final Map<ProfesorId, Profesor> categorias = CategoriaFactory.getDemoData();

    //Mejora para calcular el id de la creación que viene vacío
  @Override
    public Profesor save(Profesor t) {
            //create
        if(t.getId()==null) t.setId(new ProfesorId(obtenerSiguienteId()));

        categorias.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId(){
        ProfesorId ultimo =new ProfesorId(0);

        if(!categorias.isEmpty()){
            Collection<Profesor> lista = categorias.values();
            
            for (Profesor c : lista) {
                ultimo = c.getId();
            } 

        }
        return ultimo.getValue()+1;
    }

    @Override
    public List<Profesor> getAll() {
        return new ArrayList<>(categorias.values());
    }

    @Override
    public Optional<Profesor> getById(ProfesorId id) {
        // Un optional puede tener una valor o no. Si no existe el producto devuelve
        // Optional.empty
        return Optional.ofNullable(categorias.get(id));
    }

    @Override
    public void deleteById(ProfesorId id) {
        categorias.remove(id);
    }

    /*
     * @Override No está incluido en CategoriaRepository.
     * public Optional<Categoria> getByName(String name) {
     * // TODO Sin implementar
     * throw new UnsupportedOperationException("Unimplemented method 'getByName'");
     * }
     */
}
