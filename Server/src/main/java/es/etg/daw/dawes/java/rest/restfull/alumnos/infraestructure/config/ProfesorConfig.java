package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.CreateProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.DeleteProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.EditProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.profesor.FindProfesorUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProfesorConfig {
    
    private final ProfesorRepository profesorRepository;

    @Bean
    public CreateProfesorUseCase createProfesorUseCase() {
        return new CreateProfesorUseCase(profesorRepository);
    }

    @Bean
    public CreateProfesorService createProfesorService() {
        return new CreateProfesorService(createProfesorUseCase());
    }

    @Bean
    public FindProfesorUseCase findProfesorUseCase() {
        return new FindProfesorUseCase(profesorRepository);
    }

    @Bean
    public FindProfesorService findProfesorService() {
        return new FindProfesorService(findProfesorUseCase());
    }

    @Bean
    public DeleteProfesorUseCase deleteProfesorUseCase() {
        return new DeleteProfesorUseCase(profesorRepository);
    }

    @Bean
    public DeleteProfesorService deleteProfesorService() {
        return new DeleteProfesorService(deleteProfesorUseCase());
    }

    @Bean
    public EditProfesorUseCase editProfesorUseCase() {
        return new EditProfesorUseCase(profesorRepository);
    }
    
    @Bean
    public EditProfesorService editProfesorService() {
        return new EditProfesorService(editProfesorUseCase());
    }
}