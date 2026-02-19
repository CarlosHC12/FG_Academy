package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.EditAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.usecase.alumno.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository.AlumnoEntityJpaRepository;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.repository.AlumnoJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {

    private final AlumnoEntityJpaRepository alumnoEntityJpaRepository;

    // Creo por configuración la instancia que me interesa del alumnoRepository (desde jpa)
    @Bean
    public AlumnoRepository alumnoRepository() {
        return new AlumnoJpaRepositoryImpl(alumnoEntityJpaRepository);
    }
    
    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase() {
        return new CreateAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public EditAlumnoUseCase editAlumnoUseCase() {
        return new EditAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public FindAlumnoUseCase findAlumnoUseCase() {
        return new FindAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public DeleteAlumnoUseCase deleteAlumnoUseCase() {
        return new DeleteAlumnoUseCase(alumnoRepository());
    }
}
