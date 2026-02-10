package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProductoUseCase {

    private final ProductoRepository productoRepository;
    
    public void delete(AlumnoId id){ //Lo cambiamos
        productoRepository.deleteById(id);
    }
}