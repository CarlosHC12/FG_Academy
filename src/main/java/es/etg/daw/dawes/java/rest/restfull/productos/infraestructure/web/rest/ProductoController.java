package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.ProductoMapper;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/productos") //La url será /productos
@RequiredArgsConstructor
public class ProductoController {
	
	private final CreateProductoService createProductoService;

	// Nuevo atributo
    private final FindProductoService findProductoService;
    
    private final EditProductoService editProductoService;

    private final DeleteProductoService deleteProductoService;

    @GetMapping
    public List<ProductoResponse> allProductos(){

        return findProductoService.findAll()
                .stream() //Convierte la lista en un flujo
                .map(ProductoMapper::toResponse) //Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto de Respuesta (ProductoResponse)
                .toList(); //Lo devuelve como una lista.

    }

	@PostMapping //Método Post
    public ResponseEntity<ProductoResponse> createProducto(
              // Indicamos que valide los datos de la request
            @Valid
            @RequestBody 
                ProductoRequest productoRequest) {
        CreateProductoCommand comando = ProductoMapper.toCommand(productoRequest); 
        Producto producto = createProductoService.createProducto(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoMapper.toResponse(producto)); //Respuesta
    }


	@PutMapping("/{id}")
    public ProductoResponse editProducto(@PathVariable int id, @RequestBody ProductoRequest productoRequest){
        EditProductoCommand comando = ProductoMapper.toCommand(id, productoRequest);
        Producto producto = editProductoService.update(comando);

        return  ProductoMapper.toResponse(producto); //Respuesta
    }


   @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteProducto(@PathVariable int id) {
        deleteProductoService.delete(new ProductoId(id)); //convertimos id en ProductoId
        return ResponseEntity.noContent().build();
    }
    

}

