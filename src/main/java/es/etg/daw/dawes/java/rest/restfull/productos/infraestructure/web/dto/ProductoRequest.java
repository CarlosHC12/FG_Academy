package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.validation.NombradoProducto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductoRequest(
                @NotBlank (message = "{producto.valid.nombre.no_vacio}")
                @NombradoProducto (message = "{producto.valid.nombre.nombrado_validation}")
                    String nombre, 
                @Min(value = 0, message = "{producto.valid.precio.min}") 
                @Max(value = 100, message = "{producto.valid.precio.max}")
                    double precio) {

}

                // // Método que captura los errores y devuelve un mapa con el campo que no cumple la validación y un mensaje de error.
                // @ResponseStatus(HttpStatus.BAD_REQUEST)
                // @ExceptionHandler(MethodArgumentNotValidException.class)
                // public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
                //     Map<String, String> errors = new HashMap<>();
                //     ex.getBindingResult().getAllErrors().forEach((error) -> {
                //         String fieldName = ((FieldError) error).getField();
                //         String errorMessage = error.getDefaultMessage();
                //         errors.put(fieldName, errorMessage);
                //     });
                //     return errors;
                // }

                //si hay que quitarlo de otra clase esta en productonotfoundexception








// Método que captura los errores y devuelve un mapa con el campo que no cumple la validación y un mensaje de error.
