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
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository.ProfesorEntityJpaRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository.ProfesorJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProfesorConfig {

    private final ProfesorEntityJpaRepository profesorEntityJpaRepository;

    @Bean
    public ProfesorRepository profesorRepository() {
        return new ProfesorJpaRepositoryImpl(profesorEntityJpaRepository);
    }

    @Bean
    public CreateProfesorUseCase createProfesorUseCase() {
        return new CreateProfesorUseCase(profesorRepository());
    }

    @Bean
    public FindProfesorUseCase findProfesorUseCase() {
        return new FindProfesorUseCase(profesorRepository());
    }

    @Bean
    public DeleteProfesorUseCase deleteProfesorUseCase() {
        return new DeleteProfesorUseCase(profesorRepository());
    }

    @Bean
    public EditProfesorUseCase editProfesorUseCase() {
        return new EditProfesorUseCase(profesorRepository());
    }
}
