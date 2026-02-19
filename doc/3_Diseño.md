# 3. Diseño

[← Volver al índice](../index.md) | [Anterior: Casos de Uso y Requisitos](2_Casos_de_Uso_y_Requisitos.md) | [Siguiente: Arquitectura y Despliegue →](4_Arquitectura_y_Despliegue.md)

---

## 3.1 GUI

La interfaz gráfica de la aplicación está construida con HTML5, CSS3 y JavaScript, utilizando Thymeleaf como motor de plantillas. El diseño combina fondos oscuros con acentos en amarillo dorado y verde, creando una estética inspirada en los juegos de lucha arcade.

La estructura visual se compone de:
- Cabecera con logo, título y selectores de idioma (español, inglés, japonés, coreano)
- Barra de navegación con enlaces a Inicio, Gestión y Guías
- Área de contenido principal que varía según la página visitada
- Pie de página con información de copyright

---

## 3.2 UI (vistas)

**Página Principal (`main.html`)**
- Hero section con título "APRENDE, COMPITE, DOMINA"
- Botones de llamada a la acción
- Sección de características con tarjetas explicativas
- Carrusel de juegos
- Sección de noticias
- Formulario de contacto

**Página de Gestión (`gestion.html`)**
- Panel de selección con tarjetas de Alumnos y Profesores
- Estadísticas de totales
- Botones para añadir y descargar PDF
- Filtros de búsqueda por ID, nombre y profesor/juego
- Tablas con datos y botones de editar/eliminar
- Mensajes informativos cuando no hay registros

**Página de Administración (`admin.html`)**
- Estadísticas resumidas
- Listado completo de alumnos
- Listado completo de profesores

**Página de Crear Alumno (`crear-alumno.html`)**
- Formulario con campos para nombre, edad y selector de profesor
- Botones para crear y cancelar
- Modal de confirmación al enviar

**Página de Crear Profesor (`crear-profesor.html`)**
- Formulario con campos para nombre y selector de juego
- Botones para crear y cancelar
- Modal de confirmación al enviar

---

## 3.3 UX (usabilidad)

- **Consistencia:** mismos patrones de diseño en todas las páginas
- **Feedback:** modales de confirmación tras cada operación
- **Prevención de errores:** confirmación antes de eliminar
- **Reconocimiento:** iconos intuitivos (editar, eliminar, añadir)
- **Flexibilidad:** filtros para búsquedas rápidas
- **Visibilidad de estado:** totales actualizados y mensajes informativos

---

## 3.4 IxD

- Paneles intercambiables mediante clic en tarjetas
- Filtros con botones de aplicar y limpiar
- Modales de confirmación para acciones destructivas
- Botones de acción directa en cada fila de tabla
- Redirección tras completar formularios

---

## 3.5 Diagrama navegación

[Aquí iría el diagrama de navegación en PlantUML]

El diagrama muestra el flujo entre la página principal, gestión, administración, creación de alumnos, creación de profesores y las acciones de edición y eliminación.

---

## 3.6 Reutilización

- Tarjetas de selección (alumnos/profesores)
- Tablas de datos
- Botones de acción (editar, eliminar)
- Modales de confirmación
- Sistema de filtros
- Selectores de idioma

---

## 3.7 Arquitectura

[Aquí iría el diagrama de arquitectura en PlantUML]

La arquitectura sigue una estructura de capas que separa la presentación, la lógica de negocio y el acceso a datos.

---

## 3.8 Despliegue

[Aquí iría el diagrama de despliegue en PlantUML]

La aplicación se despliega como un archivo JAR ejecutable con Spring Boot embebido, utilizando una base de datos H2 y opcionalmente empaquetada en un contenedor Docker.

---

## 3.9 Componentes

[Aquí iría el diagrama de componentes en PlantUML]

Los componentes principales incluyen controladores, servicios, repositorios, mappers y entidades JPA para la gestión de alumnos y profesores.

---

## 3.10 Diseño de los servicios REST

**Alumnos**
- GET /api/alumnos - Listar todos
- GET /api/alumnos/{id} - Obtener por ID
- POST /api/alumnos - Crear nuevo
- PUT /api/alumnos/{id} - Actualizar
- DELETE /api/alumnos/{id} - Eliminar

**Profesores**
- GET /api/profesores - Listar todos
- GET /api/profesores/{id} - Obtener por ID
- POST /api/profesores - Crear nuevo
- PUT /api/profesores/{id} - Actualizar
- DELETE /api/profesores/{id} - Eliminar

**Reportes**
- GET /reportes/alumnos/pdf - Descargar PDF de alumnos
- GET /reportes/profesores/pdf - Descargar PDF de profesores

---

## 3.11 Base de datos

**Tabla PROFESORES**
- id (clave primaria)
- nombre
- juego
- fecha_creacion

**Tabla ALUMNOS**
- id (clave primaria)
- nombre
- edad
- profesor_id (clave foránea)
- fecha_creacion

Relación: un profesor puede tener varios alumnos

---

## 3.12 Paquetes, Interfaces y Clases

**Estructura de paquetes**

es.etg.daw.dawes.java.rest.restfull/
├── alumnos/
│ ├── application/
│ ├── domain/
│ └── infraestructure/
├── common/
└── thym/
└── infraestructure/web/


**Clases principales**
- `Alumno`, `Profesor` - Entidades del dominio
- `AlumnoId`, `ProfesorId` - Value objects para identificadores
- `AlumnoRepository`, `ProfesorRepository` - Interfaces de repositorio
- `CreateAlumnoService`, `FindAlumnoService` - Servicios de aplicación
- `CreateAlumnoUseCase`, `FindAlumnoUseCase` - Casos de uso
- `AlumnoController`, `ProfesorController` - Controladores REST
- `PaginasController` - Controlador de vistas
- `AlumnoMapper`, `ProfesorMapper` - Mapeadores entre capas
- `AlumnoEntity`, `ProfesorEntity` - Entidades JPA

---

## 3.13 Plan de pruebas

**Pruebas unitarias**
- Servicios: verificar operaciones CRUD
- Casos de uso: validar lógica de negocio
- Mappers: comprobar conversiones correctas
- Validaciones: asegurar rechazo de datos incorrectos

**Pruebas de integración**
- Repositorios con base de datos H2 embebida
- Controladores REST con peticiones simuladas
- Servicios con repositorios reales

**Pruebas funcionales**
- Creación de alumnos y profesores
- Edición de registros existentes
- Eliminación con confirmación
- Filtros en listados
- Exportación de PDF
- Cambio de idioma

**Herramientas**
- JUnit 5
- Mockito
- Spring Boot Test
- Postman

---

[← Anterior: Casos de Uso y Requisitos](2_Casos_de_Uso_y_Requisitos.md) | [Volver al índice](../index.md) | [Siguiente: Arquitectura y Despliegue →](4_Arquitectura_y_Despliegue.md) 
