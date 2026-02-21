# 2. Contexto de la aplicación

[← Anterior: Introducción](1_Introduccion.md) | [Volver al índice](../README.md) | [Siguiente: Diseño →](3_Diseno.md)

---

## 2.1 Mundo real del problema

Hoy en dia los e-sports son cada vez mas relevantes, llegando a tener muchos espectadores, igualandose cada vez mas con deportes normales, llegando al punto de ser reconocido como deporte por el comite olimpico (Solo en arabia saudi) y eso desemboco en el nacimiento de escuelas dedicados a los e-sports de los juegos populares o mainstream, lol, valorant cs2 etc, pero no existen del genero de peleas/lucha o fighting y es ahi donde nace FG_Academy, como una iniciativa para potenciar los figthing games en españa, y quitar el miedo a estos juegos.

---

## 2.2 Qué app existen

Tecnicamente no existe una aplicacion dedicada a escuelas de figting pero si excisten guias.

| Aplicación | Funcionalidad | Limitaciones |
|------------|---------------|---------------|
| Dustloop Wiki | Guías de personajes | Solo información, sin gestión |
| SuperCombo | Foros y guías | Desorganizado, sin estructura |
| Discord | Comunidades | Difícil de gestionar información |

---

## 2.3 Cómo la mía es mucho mejor porque hace...

**FG Academy** combina la gestión académica con guías especializadas en un solo lugar:

- **Gestión académica**: CRUD completo de alumnos y profesores
- **Guías especializadas**: Información estructurada por personaje
- **Reportes en PDF**: Exportación de listados
- **Internacionalización**: Soporte para 4 idiomas
- **Diseño responsive**: Interfaz moderna y adaptable

---

## 2.3.1 Casos de Uso (Actores son agentes externos a mi app)

| ID | Caso de Uso | Actor | Descripción |
|----|-------------|-------|-------------|
| UC1 | Gestionar Alumnos | Administrador | Crear, editar, eliminar y listar alumnos |
| UC2 | Gestionar Profesores | Administrador | Crear, editar, eliminar y listar profesores |
| UC3 | Visualizar Guías | Usuario | Ver guías detalladas de personajes |
| UC4 | Exportar PDF | Administrador | Generar y descargar listados en PDF |
| UC5 | Cambiar Idioma | Usuario | Cambiar el idioma de la interfaz |
| UC6 | Filtrar Listados | Usuario | Filtrar alumnos/profesores por criterios |

---

## 2.3.2 Requisitos F y NF

### 2.3.2.1 Requisitos Funcionales (F)

| ID | Requisito | Prioridad |
|----|-----------|-----------|
| RF01 | El sistema debe permitir crear, editar y eliminar alumnos | Alta |
| RF02 | El sistema debe permitir crear, editar y eliminar profesores | Alta |
| RF03 | El sistema debe listar alumnos y profesores con filtros | Alta |
| RF04 | El sistema debe generar PDFs con los listados | Media |
| RF05 | El sistema debe mostrar guías de personajes | Media |
| RF06 | El sistema debe soportar múltiples idiomas | Alta |

### 2.3.2.2 Requisitos No Funcionales (NF)

| ID | Requisito | Descripción |
|----|-----------|-------------|
| RNF01 | Rendimiento | Tiempo de respuesta < 2 segundos |
| RNF02 | Seguridad | Protección contra inyección SQL y XSS |
| RNF03 | Usabilidad | Interfaz intuitiva y responsive |
| RNF04 | Mantenibilidad | Código estructurado en capas |
| RNF05 | Internacionalización | Soporte para español, inglés, japonés y coreano |

---

[← Anterior: Introducción](1_Introduccion.md) | [Volver al índice](../README.md) | [Siguiente: Diseño →](3_Diseño.md)