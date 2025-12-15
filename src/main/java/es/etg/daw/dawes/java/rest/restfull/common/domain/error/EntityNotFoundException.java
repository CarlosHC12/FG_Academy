package es.etg.daw.dawes.java.rest.restfull.common.domain.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entity) {
        super("%s no encontrado".formatted(entity));
    }

    public EntityNotFoundException(String entity, int id){
        super("%s con id %s no se encuentra".formatted(entity, id));
    }
    
     // Método que captura los errores y devuelve un mapa con el campo que no cumple la validación y un mensaje de error.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}