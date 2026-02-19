package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.DeleteProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.EditProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.ProfesorMapper;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profesores")
@RequiredArgsConstructor
public class ProfesorRestController {

    private final CreateProfesorService createProfesorService;
    private final FindProfesorService findProfesorService;
    private final DeleteProfesorUseCase deleteProfesorService;
    private final EditProfesorUseCase editProfesorService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> createProfesor(
            @Valid @RequestBody ProfesorRequest profesorRequest) {
        CreateProfesorCommand comando = ProfesorMapper.toCommand(profesorRequest);
        Profesor profesor = createProfesorService.createProfesor(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfesorMapper.toResponse(profesor));
    }

    @GetMapping
    public List<ProfesorResponse> allProfesores() {
        return findProfesorService.findAll()
                .stream()
                .map(ProfesorMapper::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable int id) {
        deleteProfesorService.delete(new ProfesorId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ProfesorResponse editProfesor(@PathVariable int id,
                                         @Valid @RequestBody ProfesorRequest profesorRequest) {
        EditProfesorCommand comando = ProfesorMapper.toCommand(id, profesorRequest);
        Profesor profesor = editProfesorService.update(comando);
        return ProfesorMapper.toResponse(profesor);
    }
}