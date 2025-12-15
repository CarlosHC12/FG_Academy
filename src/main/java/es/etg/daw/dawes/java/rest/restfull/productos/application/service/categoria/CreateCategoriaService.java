package es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.CreateCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateCategoriaService {

	private final CreateCategoriaUseCase createCategoriaUseCase;

	public Producto createCategoria(CreateCategoriaCommand comando){
		Producto Categoria = createCategoriaUseCase.create(comando);
		return Categoria;
	}
	
}