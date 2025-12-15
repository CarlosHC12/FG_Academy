package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditProductoService {

    private final EditProductoUseCase editProductoUseCase;

    // nombre en camelCase y delega al use case (evita recursión)
    public Producto editProducto(EditProductoCommand comando) {
        return editProductoUseCase.update(comando);
    }

    // si quieres mantener un alias llamado update, haz que también delegue
    public Producto update(EditProductoCommand comando) {
        return editProductoUseCase.update(comando);
    }
}