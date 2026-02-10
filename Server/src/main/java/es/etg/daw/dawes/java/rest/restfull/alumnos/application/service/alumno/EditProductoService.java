package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EditProductoService {

      private final EditProductoUseCase editProductoUseCase;

    public Alumno update(EditProductoCommand editProductoCommand) {
      
        return  editProductoUseCase.update(editProductoCommand);
    }
}
