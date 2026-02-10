package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.ProductoEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoResponse;


public class ProductoMapper {

    public static ProductoEntity toEntity(Alumno p){
    CategoriaEntity cat = new CategoriaEntity();
    cat.setId(p.getCategoria().getValue());

    return ProductoEntity.builder()
            .nombre(p.getNombre())
            .precio(BigDecimal.valueOf(p.getPrecio()))
            .fechaCreacion(p.getCreatedAt() != null ? p.getCreatedAt() : LocalDateTime.now())
            .categoria(cat)
            .build(); // No pases ID
}

    public static CreateProductoCommand toCommand(ProductoRequest req){
        return new CreateProductoCommand(req.nombre(), req.precio(), new ProfesorId(req.categoriaId()));
    }

    public static EditProductoCommand toCommand(int id, ProductoRequest req){
        return new EditProductoCommand(new AlumnoId(id), req.nombre(), req.precio(), new ProfesorId(req.categoriaId()));
    }

    public static ProductoResponse toResponse(Alumno p){
        return new ProductoResponse(p.getId().getValue(), p.getNombre(), p.getPrecio(), p.getCreatedAt(), p.getCategoria().getValue());
    }

    public static Alumno toDomain(ProductoEntity p) {
    // Asegúrate de que p.getId() no sea null
    if (p.getId() == null) {
        throw new IllegalStateException("El ID de la entidad no puede ser nulo");
    }
    return Alumno.builder()
            .id(new AlumnoId(p.getId())) // Esto es clave
            .nombre(p.getNombre())
            .precio(p.getPrecio().doubleValue())
            .createdAt(p.getFechaCreacion())
            .categoria(new ProfesorId(p.getCategoria().getId()))
            .build();
}

    public static List<Alumno> toDomain(List<ProductoEntity> lista){
        List<Alumno> lp = new ArrayList<>();
        for(ProductoEntity pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }
}
