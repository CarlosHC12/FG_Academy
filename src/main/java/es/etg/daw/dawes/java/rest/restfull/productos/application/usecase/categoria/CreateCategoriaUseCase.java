package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoriaUseCase {
    
    private CategoriaRepository categoriaRepository;

    public Producto create( CreateCategoriaCommand comando){

        Producto categoria = Producto.builder() // Se puede usar comando.id y no getId por usar @Accessors(fluent = true) la clase CreateProductoCommand 
                                    .nombre(comando.nombre())
                                    .createdAt(LocalDateTime.now()).build();

        categoriaRepository.save(categoria);
        return categoria;

    }
}