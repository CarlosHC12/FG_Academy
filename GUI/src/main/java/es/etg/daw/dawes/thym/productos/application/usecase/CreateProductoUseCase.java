package es.etg.daw.dawes.thym.productos.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.thym.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.thym.productos.domain.model.Producto;
import es.etg.daw.dawes.thym.productos.domain.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateProductoUseCase {

	private final ProductoRepository productoRepository;

	

	public Producto create(CreateProductoCommand comando) {

		// Se puede usar comando.id() y no getId() por usar @Accessors(fluent = true)
		// en la clase CreateProductoCommand

		Producto producto = Producto.builder()
				.nombre(comando.nombre())
				.precio(comando.precio()).build();
				
		return productoRepository.save(producto);

	}
}