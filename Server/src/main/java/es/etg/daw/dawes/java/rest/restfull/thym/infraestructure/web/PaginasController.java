package es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.EditAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.ProfesorMapper;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorRequest;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.enums.ThymView;
import lombok.RequiredArgsConstructor;
// ============ IMPORTS CORRECTOS ============
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List; // ← IMPORTANTÍSIMO: java.util.List, NO java.awt.List
// ===========================================

@Controller
@RequiredArgsConstructor
public class PaginasController {

    private final FindAlumnoService findAlumnoService;
    private final FindProfesorService findProfesorService;
    private final EditAlumnoService editAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;
    private final EditProfesorService editProfesorService;
    private final DeleteProfesorService deleteProfesorService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/arcade")
    public String arcade() {
        return "arcade";
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

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("alumnos", findAlumnoService.findAll());
        model.addAttribute("profesores", findProfesorService.findAll());
        model.addAttribute("totalAlumnos", findAlumnoService.findAll().size());
        model.addAttribute("totalProfesores", findProfesorService.findAll().size());
        return "admin";
    }

    // ============ EDITAR ALUMNO ============
    @PostMapping("/editar/alumno")
    public String editarAlumno(@RequestParam int id,
            @RequestParam String nombre,
            @RequestParam int edad,
            @RequestParam int profesorId) {
        AlumnoRequest request = new AlumnoRequest(nombre, edad, profesorId);
        EditAlumnoCommand command = AlumnoMapper.toCommand(id, request);
        editAlumnoService.update(command);
        return "redirect:/admin";
    }

    // ============ ELIMINAR ALUMNO ============
    @GetMapping("/eliminar/alumno/{id}")
    public String eliminarAlumno(@PathVariable int id) {
        deleteAlumnoService.delete(new AlumnoId(id));
        return "redirect:/admin";
    }

    // ============ EDITAR PROFESOR ============
    @PostMapping("/editar/profesor")
    public String editarProfesor(@RequestParam int id,
            @RequestParam String nombre) {
        ProfesorRequest request = new ProfesorRequest(nombre);
        EditProfesorCommand command = ProfesorMapper.toCommand(id, request);
        editProfesorService.update(command);
        return "redirect:/admin";
    }

    // ============ ELIMINAR PROFESOR ============
    @GetMapping("/eliminar/profesor/{id}")
    public String eliminarProfesor(@PathVariable int id) {
        deleteProfesorService.delete(new ProfesorId(id));
        return "redirect:/admin";
    }

}