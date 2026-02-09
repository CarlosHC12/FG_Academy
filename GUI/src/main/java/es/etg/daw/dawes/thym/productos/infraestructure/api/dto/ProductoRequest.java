package es.etg.daw.dawes.thym.productos.infraestructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class  ProductoRequest{
    Integer id;
    String nombre;
    double precio;
    Integer categoriaId = 1;
}


