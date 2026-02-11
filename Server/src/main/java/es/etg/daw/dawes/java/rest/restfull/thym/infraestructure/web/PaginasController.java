package es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.enums.ThymView;
import lombok.RequiredArgsConstructor;
// ============ IMPORTS CORRECTOS ============
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.FindProfesorService;  
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;  // ← IMPORTANTÍSIMO: java.util.List, NO java.awt.List
// ===========================================


@Controller
@RequiredArgsConstructor
public class PaginasController {

    private final FindAlumnoService findAlumnoService;
    private final FindProfesorService findProfesorService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping(WebRoutes.ALUMNOS_PRUEBA)
    public String alumnosPrueba(Model model) {
        model.addAttribute(ModelAttribute.ALUMNOS.getName(), findAlumnoService.findAll());
        return ThymView.ALUMNOS_PRUEBA.getPath();
    }
    

    @GetMapping("/gestion")
    public String gestion(Model model) {
        
        // Obtener datos reales de la base de datos
        List<Alumno> alumnos = findAlumnoService.findAll();
        List<Profesor> profesores = findProfesorService.findAll();
        
        // Añadir al modelo para Thymeleaf
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("profesores", profesores);
        model.addAttribute("totalAlumnos", alumnos.size());
        model.addAttribute("totalProfesores", profesores.size());
        
        // Devuelve la plantilla: /src/main/resources/templates/gestion.html
        return "gestion";
    }
 

    
}