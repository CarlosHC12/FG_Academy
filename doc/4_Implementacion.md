# 4. Implementación

[← Anterior: Diseño](3_Diseño.md) | [Volver al índice](../README.md) | [Siguiente: Capturas →](5_Capturas.md)

---

## 4.1 Entorno de Desarrollo

### Gestión de versiones

- **Sistema**: Git
- **Repositorio**: GitHub
- **Ramas**: `main`, `develop`, `feature/*`

### Estructura del proyecto
FG_Academy/
├── Server/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/
│ │ │ └── resources/
│ │ └── test/
│ ├── pom.xml
│ └── README.md
├── docs/
└── .gitignore

text

### Documentación

La documentación está en `docs/` en formato Markdown.

### Compilación

- `mvn clean` - Limpiar
- `mvn compile` - Compilar
- `mvn test` - Probar
- `mvn package` - Empaquetar
- `mvn spring-boot:run` - Ejecutar

[VER ANEXO 1: pom.xml al final del documento]

### Librerías y frameworks

| Librería | Versión | Uso |
|----------|---------|-----|
| Spring Boot | 3.1.x | Framework |
| Spring MVC | 6.0.x | Controladores |
| Spring Data JPA | 3.1.x | Persistencia |
| Thymeleaf | 3.1.x | Vistas |
| H2 Database | 2.2.x | BD |
| Lombok | 1.18.x | Código |
| Flying Saucer | 9.1.x | PDF |
| JUnit 5 | 5.9.x | Pruebas |

### Lenguajes

- Java 17
- HTML5/CSS3/JavaScript
- SQL

---

## 4.1.1 EXTRA: Desarrollo utilizando un DevContainer

**¿Qué es?**
Entorno de desarrollo en contenedor Docker con todo preconfigurado.

**Configuración:**
[VER ANEXO 2: devcontainer.json al final del documento]

**Uso:**
1. Instalar Docker y VS Code
2. Extensión "Dev Containers"
3. `Ctrl+Shift+P` → "Reopen in Container"

---

## 4.1.2 Implantación/Puesta en producción

**Requisitos del sistema:**
- CPU: 1 núcleo
- RAM: 512 MB
- Disco: 100 MB
- Java: JDK 17
- Docker: opcional

**Perfiles de configuración:**
- `dev`: Desarrollo (H2 en memoria)
- `prod`: Producción (H2 en archivo)
- `test`: Pruebas (H2 en memoria)

**Construcción:**
mvn clean package

text

**Ejecución:**
java -jar fg-academy-1.0.0.jar --spring.profiles.active=prod

text

**Docker:**
[VER ANEXO 3: Dockerfile al final del documento]
[VER ANEXO 4: docker-compose.yml al final del documento]

**Verificación:**
- Página principal: http://localhost:8080
- API Alumnos: http://localhost:8080/api/alumnos
- API Profesores: http://localhost:8080/api/profesores

---

## ANEXOS

### ANEXO 1: pom.xml

[El código del archivo pom.xml va aquí]

### ANEXO 2: devcontainer.json

[El código del archivo .devcontainer/devcontainer.json va aquí]

### ANEXO 3: Dockerfile

[El código del archivo Dockerfile va aquí]

### ANEXO 4: docker-compose.yml

[El código del archivo docker-compose.yml va aquí]

---

[← Anterior: Diseño](3_Diseno.md) | [Volver al índice](../README.md) | [Siguiente: Capturas →](5_Capturas.md)