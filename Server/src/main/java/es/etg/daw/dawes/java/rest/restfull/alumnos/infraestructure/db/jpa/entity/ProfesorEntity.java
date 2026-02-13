package es.etg.daw.dawes.java.rest.restfull.alumnos.infraestructure.db.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROFESORES")
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<AlumnoEntity> alumnos = new ArrayList<>();

    public void addAlumno(AlumnoEntity alumno) {
        this.alumnos.add(alumno);
        alumno.setProfesor(this);
    }

    public void removeAlumno(AlumnoEntity alumno) {
        this.alumnos.remove(alumno);
        alumno.setProfesor(null);
    }
}