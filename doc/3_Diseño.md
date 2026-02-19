
**Clases principales:**
- `Alumno`, `Profesor` - Entidades del dominio
- `AlumnoId`, `ProfesorId` - Objetos valor
- `AlumnoRepository`, `ProfesorRepository` - Interfaces de repositorio
- `CreateAlumnoService`, `FindAlumnoService` - Servicios
- `CreateAlumnoUseCase`, `FindAlumnoUseCase` - Casos de uso
- `AlumnoController`, `ProfesorController` - Controladores REST
- `PaginasController` - Controlador de vistas
- `AlumnoMapper`, `ProfesorMapper` - Mapeadores
- `AlumnoEntity`, `ProfesorEntity` - Entidades JPA

---

## 3.13 Plan de Pruebas

**Pruebas Unitarias:**
- Servicios (CRUD)
- Casos de uso (lógica de negocio)
- Mappers (conversiones)
- Validaciones

**Pruebas de Integración:**
- Repositorios con H2 embebida
- Controladores REST
- Servicios con repositorios

**Pruebas Funcionales:**
- Creación de alumnos y profesores
- Edición y eliminación
- Filtros en listados
- Exportación PDF
- Cambio de idioma

**Herramientas:**
- JUnit 5
- Mockito
- Spring Boot Test
- Postman

---

[← Anterior: Casos de Uso y Requisitos](2_Casos_de_Uso_y_Requisitos.md) | [Volver al índice](../index.md) | [Siguiente: Arquitectura y Despliegue →](4_Arquitectura_y_Despliegue.md)
