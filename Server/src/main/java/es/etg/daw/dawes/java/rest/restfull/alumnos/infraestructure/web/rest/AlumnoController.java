package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.EditAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.AlumnoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
@Tag(name = "Alumnos", description = "Operaciones relacionadas con la gestión de alumnos")
public class AlumnoController {

    private final CreateAlumnoService createAlumnoService;
    private final FindAlumnoService findAlumnoService;
    private final DeleteAlumnoUseCase deleteAlumnoService;
    private final EditAlumnoUseCase editAlumnoService;

    @PostMapping
    public ResponseEntity<AlumnoResponse> createAlumno(
            @Valid @RequestBody AlumnoRequest alumnoRequest) {
        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno alumno = createAlumnoService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno));
    }

    @Operation(summary = "Obtiene el listado de alumnos", description = "Busca en la base de datos todos los alumnos y sus detalles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de alumnos generado"),
            @ApiResponse(responseCode = "404", description = "No hay alumnos en la base de datos")
    })
    @GetMapping
    public List<AlumnoResponse> allAlumnos() {
        return findAlumnoService.findAll()
                .stream()
                .map(AlumnoMapper::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable int id) {
        deleteAlumnoService.delete(new AlumnoId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public AlumnoResponse editAlumno(@PathVariable int id,
                                     @Valid @RequestBody AlumnoRequest alumnoRequest) {
        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno);
    }

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