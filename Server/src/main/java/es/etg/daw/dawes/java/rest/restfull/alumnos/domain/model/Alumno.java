package es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder


public class Alumno{
    
    private AlumnoId id;
    private String nombre;
    private int edad;
    private LocalDateTime createdAt;


    //Agregamos la categoría
    private AlumnoId categoria;

    
    
}
