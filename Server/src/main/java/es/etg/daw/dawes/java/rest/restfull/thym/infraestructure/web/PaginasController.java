package es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web;

import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.EditAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.AlumnoId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.Profesor;
import es.etg.daw.dawes.java.rest.restfull.alumnos.domain.model.ProfesorId;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.mapper.ProfesorMapper;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.web.dto.ProfesorRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PaginasController {

    private final FindAlumnoService findAlumnoService;
    private final FindProfesorService findProfesorService;
    private final EditAlumnoService editAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;
    private final EditProfesorService editProfesorService;
    private final DeleteProfesorService deleteProfesorService;
    private final CreateAlumnoService createAlumnoService;
    private final CreateProfesorService createProfesorService;

    // TemplateEngine para generar PDFs
    private final TemplateEngine templateEngine;

    // ============ PÁGINAS ESTÁTICAS ============
    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/arcade")
    public String arcade() {
        return "arcade";
    }

    // ============ GESTIÓN ============
    @GetMapping("/gestion")
    public String gestion(Model model) {
        List<Alumno> alumnos = findAlumnoService.findAll();
        List<Profesor> profesores = findProfesorService.findAll();

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("profesores", profesores);
        model.addAttribute("totalAlumnos", alumnos.size());
        model.addAttribute("totalProfesores", profesores.size());

        return "gestion";
    }

    // ============ ADMIN (GESTIÓN COMPLETA) ============
    @GetMapping("/admin")
    public String admin(Model model) {
        List<Alumno> alumnos = findAlumnoService.findAll();
        List<Profesor> profesores = findProfesorService.findAll();

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("profesores", profesores);
        model.addAttribute("totalAlumnos", alumnos.size());
        model.addAttribute("totalProfesores", profesores.size());
        return "admin";
    }

    // ============ EDITAR ALUMNO ============
    @PostMapping("/editar/alumno")
    public String editarAlumno(@RequestParam int id,
            @RequestParam String nombre,
            @RequestParam int edad,
            @RequestParam int profesorId,
            RedirectAttributes redirectAttributes) {
        try {
            AlumnoRequest request = new AlumnoRequest(nombre, edad, profesorId);
            EditAlumnoCommand command = AlumnoMapper.toCommand(id, request);
            editAlumnoService.update(command);
            redirectAttributes.addFlashAttribute("mensaje", "Alumno actualizado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar el alumno");
        }
        return "redirect:/admin";
    }

    // ============ ELIMINAR ALUMNO ============
    @GetMapping("/eliminar/alumno/{id}")
    public String eliminarAlumno(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            deleteAlumnoService.delete(new AlumnoId(id));
            redirectAttributes.addFlashAttribute("mensaje", "Alumno eliminado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar el alumno");
        }
        return "redirect:/admin";
    }

    // ============ EDITAR PROFESOR ============
    @PostMapping("/editar/profesor")
    public String editarProfesor(@RequestParam int id,
            @RequestParam String nombre,
            @RequestParam String juego,
            RedirectAttributes redirectAttributes) {
        try {
            ProfesorRequest request = new ProfesorRequest(nombre, juego);
            EditProfesorCommand command = ProfesorMapper.toCommand(id, request);
            editProfesorService.update(command);
            redirectAttributes.addFlashAttribute("mensaje", "Profesor actualizado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al actualizar el profesor");
        }
        return "redirect:/admin";
    }

    // ============ ELIMINAR PROFESOR ============
    @GetMapping("/eliminar/profesor/{id}")
    public String eliminarProfesor(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            deleteProfesorService.delete(new ProfesorId(id));
            redirectAttributes.addFlashAttribute("mensaje", "Profesor eliminado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar el profesor");
        }
        return "redirect:/admin";
    }

    // ============ CREAR ALUMNO (FORMULARIO) ============
    @GetMapping("/crear/alumno")
    public String formularioAlumno(Model model) {
        model.addAttribute("profesores", findProfesorService.findAll());
        return "crear-alumno";
    }

    // ============ CREAR PROFESOR (FORMULARIO) ============
    @GetMapping("/crear/profesor")
    public String formularioProfesor() {
        return "crear-profesor";
    }

    // ============ CREAR ALUMNO (POST) ============
    @PostMapping("/crear/alumno")
    public String crearAlumno(
            @RequestParam String nombre,
            @RequestParam int edad,
            @RequestParam int profesorId,
            RedirectAttributes redirectAttributes) {
        try {
            AlumnoRequest request = new AlumnoRequest(nombre, edad, profesorId);
            CreateAlumnoCommand command = AlumnoMapper.toCommand(request);
            Alumno alumno = createAlumnoService.createAlumno(command);

            redirectAttributes.addFlashAttribute("creado", "true");
            redirectAttributes.addFlashAttribute("nombreCreado", alumno.getNombre());
            redirectAttributes.addFlashAttribute("mensaje", "Alumno creado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al crear el alumno");
        }
        return "redirect:/admin";
    }

    // ============ CREAR PROFESOR (POST) ============
    @PostMapping("/crear/profesor")
    public String crearProfesor(
            @RequestParam String nombre,
            @RequestParam String juego,
            RedirectAttributes redirectAttributes) {
        try {
            ProfesorRequest request = new ProfesorRequest(nombre, juego);
            CreateProfesorCommand command = ProfesorMapper.toCommand(request);
            Profesor profesor = createProfesorService.createProfesor(command);

            redirectAttributes.addFlashAttribute("creado", "true");
            redirectAttributes.addFlashAttribute("nombreCreado", profesor.getNombre());
            redirectAttributes.addFlashAttribute("mensaje", "Profesor creado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al crear el profesor");
        }
        return "redirect:/admin";
    }

    // ============ PDF DE ALUMNOS ============
    @GetMapping("/reportes/alumnos/pdf")
    public void exportarAlumnosPdf(HttpServletResponse response) throws Exception {
        List<Alumno> alumnos = findAlumnoService.findAll();

        Context context = new Context();
        context.setVariable("alumnos", alumnos);
        context.setVariable("titulo", "Listado de Alumnos");
        context.setVariable("fecha", new java.util.Date());

        String htmlContent = templateEngine.process("pdf/alumnos", context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=alumnos.pdf");

        try (OutputStream outputStream = response.getOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }

    // ============ PDF DE PROFESORES ============
    @GetMapping("/reportes/profesores/pdf")
    public void exportarProfesoresPdf(HttpServletResponse response) throws Exception {
        List<Profesor> profesores = findProfesorService.findAll();

        Context context = new Context();
        context.setVariable("profesores", profesores);
        context.setVariable("titulo", "Listado de Profesores");
        context.setVariable("fecha", new java.util.Date());

        String htmlContent = templateEngine.process("pdf/profesores", context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=profesores.pdf");

        try (OutputStream outputStream = response.getOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }
}