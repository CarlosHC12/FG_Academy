package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.CategoriaResponse;

public class CategoriaMapper {

    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest){
        return new CreateCategoriaCommand(categoriaRequest.nombre());
    }
    public static EditCategoriaCommand toCommand(int id, CategoriaRequest categoriaRequest){
        return new EditCategoriaCommand(new ProfesorId(id),categoriaRequest.nombre());
    }
    public static CategoriaResponse toResponse(Profesor categoria){
        return new CategoriaResponse(categoria.getId().getValue(),
                                      categoria.getNombre(),
                                      categoria.getCreatedAt());
    }
    
}



