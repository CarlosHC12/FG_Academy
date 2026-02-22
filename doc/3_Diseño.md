# 3. Diseño

[← Anterior: Contexto](2_Contexto.md) | [Volver al índice](../README.md) | [Siguiente: Implementación →](4_Implementacion.md)

---

## 3.1 GUI

La interfaz gráfica está construida con HTML5, CSS3 y JavaScript, utilizando Thymeleaf como motor de plantillas. El diseño combina fondos oscuros con acentos en amarillo dorado y verde.

### 3.1.1 UI (vistas)

- **Página Principal**: Hero section, características, carrusel de juegos
- **Página de Gestión**: Paneles de alumnos y profesores con filtros
- **Página de Administración**: Listados completos
- **Crear Alumno**: Formulario con campos nombre, edad, profesor
- **Crear Profesor**: Formulario con campos nombre, juego

### 3.1.2 UX (usabilidad)

- **Consistencia**: Mismos patrones en todas las páginas
- **Feedback**: Modales de confirmación tras operaciones
- **Prevención de errores**: Confirmación antes de eliminar
- **Reconocimiento**: Iconos intuitivos 

### 3.1.3 IxD

- Paneles intercambiables mediante clic
- Filtros con botones de aplicar y limpiar
- Modales de confirmación
- Botones de acción directa en tablas



### 3.1.5 Reutilización

- Tarjetas de selección
- Tablas de datos
- Botones de acción
- Modales de confirmación
- Selectores de idioma

---

## 3.2 Arquitectura

![](Arquitectura.puml)

### 3.2.1 Despliegue

![](Despliegue.puml)

### 3.2.2 Componentes

![](DiagramaComponentes.puml)

---

## 3.3 Diseño de los servicios REST

**Alumnos:**
- `GET /api/alumnos` - Listar todos
- `GET /api/alumnos/{id}` - Obtener por ID
- `POST /api/alumnos` - Crear nuevo
- `PUT /api/alumnos/{id}` - Actualizar
- `DELETE /api/alumnos/{id}` - Eliminar

**Profesores:**
- `GET /api/profesores` - Listar todos
- `GET /api/profesores/{id}` - Obtener por ID
- `POST /api/profesores` - Crear nuevo
- `PUT /api/profesores/{id}` - Actualizar
- `DELETE /api/profesores/{id}` - Eliminar

**Reportes:**
- `GET /reportes/alumnos/pdf` - PDF de alumnos
- `GET /reportes/profesores/pdf` - PDF de profesores

---

## 3.4 Base de datos

**Tabla PROFESORES**
- id (PK)
- nombre
- juego
- fecha_creacion

**Tabla ALUMNOS**
- id (PK)
- nombre
- edad
- profesor_id (FK)
- fecha_creacion

Relación: un profesor puede tener varios alumnos.

---

## 3.5 Paquetes, Interfaces y Clases
es.etg.daw.dawes.java.rest.restfull/
├── alumnos/
│ ├── application/
│ ├── domain/
│ └── infraestructure/
├── thym/
│ └── infraestructure/
│ └── web/
└── common/

text

[AQUÍ VA EL DIAGRAMA DE CLASES EN PLANTUML]

---

## 3.6 Plan de pruebas

**Pruebas unitarias:**
- Servicios
- Casos de uso
- Mappers
- Validaciones

**Pruebas de integración:**
- Repositorios con H2 embebida
- Controladores REST
- Servicios con repositorios

**Pruebas funcionales:**
- Creación de alumnos y profesores
- Edición y eliminación
- Filtros en listados
- Exportación PDF
- Cambio de idioma

---

[← Anterior: Contexto](2_Contexto.md) | [Volver al índice](../README.md) | [Siguiente: Implementación →](4_Implementacion.md)