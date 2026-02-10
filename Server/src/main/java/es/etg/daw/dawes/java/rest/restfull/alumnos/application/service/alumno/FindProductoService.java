package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindProductoService {
    
    private final FindProductoUseCase findProductoUseCase;


     public List<Alumno> findAll() {
        return findProductoUseCase.findAll();
     }
    
}
