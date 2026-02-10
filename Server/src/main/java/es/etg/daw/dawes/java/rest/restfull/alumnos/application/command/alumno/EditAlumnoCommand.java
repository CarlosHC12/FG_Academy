package es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno;

import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

//Esta clase tiene los datos necesarios para editar un Producto
@Getter
@AllArgsConstructor
@Accessors(fluent = true) // Así los getters no llevan prefijo get
public class EditProductoCommand {
    
    private final AlumnoId id; //Lo cambiamos
    private final String nombre;
    private final double precio;
    private final ProfesorId categoriaId;
    
}