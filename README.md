# FG_Academy

## 1. Nombre de la aplicación
FG_Academy
### Versión
Actualmente solo existe una versión inicial del proyecto.

### Integrantes del equipo
- Carlos Hurtado


## 2. Contexto de la aplicación

### Mundo real del problema
En una epoca donde los e-sports estan en auge existen escuelas dedicadas a la enseñanza de "Masterizacion" de ciertos titulos, principalmente los mainstream
lol, vlorant etc..
Pero hay un genero que no tiene tannta atencion como para tener software educativo dedicado, loe juegos de lucha (o figthing games). 


### Aplicaciones existentes en el mercado
No existen aplicaciones dedicadas al aprendizaje de jugeos de lucha

### Ventajas competitivas de FG_Academy
Esta aplicación gestiona alumnos y profesores

### Casos de Uso Funcionales (F)
El usuario se conecta al sistema para crear y gestionar alumnos y profesores, estableciendo relaciones entre ellos mediante una base de datos H2.

#### Casos de Uso
- Requisitos Funcionales (F): Gestión completa de entidades (CRUD)

- Requisitos No Funcionales (NF): Usabilidad, rendimiento, mantenimiento,acceso a la base de datos a traves de usuario y contraseña. 

## 3. Diseño
### Interfaz Gráfica (GUI)
#### UI (Vistas)
Actualmente no se ha implementado una interfaz visual completa. La única interfaz disponible es la consola de administración de la base de datos H2, que requiere autenticación.

#### UX (Usabilidad)
Se accede a la base de datos mediante el navegador web a través de localhost:8080.

#### IxD (Diseño de Interacción)
Permite ejecutar consultas SQL, recuperar datos y añadir nueva información a la base de datos.

#### Diagrama de Navegación
![](imagenes/diagramanavegacion.png)

### Arquitectura
#### Diagrama de Despliegue
![](imagenes/diagramadespliegue.png)


#### Diagrama de Componentes
![](imagenes/diagramadecomponenetes.png)

### Diseño de Servicios REST
Se han implementado dos entidades principales con operaciones CRUD completas:

/alumno - GET, POST, PUT, DELETE

/profesor - GET, POST, PUT, DELETE

### Base de Datos
Se utiliza una base de datos embebida H2 para desarrollo y pruebas.

### Estructura de Paquetes, Interfaces y Clases
![](imagenes/common.png)
![](imagenes/alumnos.png)

### Plan de Pruebas
Se planea implementar:
Pruebas unitarias,Pruebas de integración y Pruebas JPA

## 4. Implementación
Entorno de Desarrollo
Gestión de versiones: Git (con dificultades en el manejo de merges)
Lenguaje: Java
Framework: Spring Boot
Entorno: DevContainer
Base de datos: H2
Arquitectura: Hexagonal con Vertical Slicing

## 5. Capturas de Ejecución
Ejecución de Pruebas
No se ha implementado la suite de pruebas por limitaciones de tiempo.

## 6. Información de Herramientas
Arquitectura: Hexagonal con Vertical Slicing
Entorno: DevContainer configurado
Framework: Spring Boot
Base de datos: H2 embebida

## 7. Elementos Destacables del Desarrollo
Dificultades con merges en GitHub
Problemas de integración al realizar merges
Limitaciones de tiempo para implementar pruebas
## 8. Manual de Usuario
Ejecución de la aplicación:
Localizar la clase principal FG_Academy
Ejecutar la aplicación desde el editor (botón "Run Java")
Verificación del inicio:
Confirmar que el servidor Spring Boot se inicia correctamente
![](imagenes/spring.png)
Acceso a la base de datos:
Abrir el navegador y navegar a localhost:8080
Ingresar credenciales en la pantalla de login
![](imagenes/login.png)
Uso de la consola H2:
Una vez autenticado, se accede a la interfaz de administración de la base de datos
![](imagenes/base.png)
Ejecutar consultas SQL y gestionar datos

## 9. Conclusiones
Ayuda a sentar unas bases en el ambito de la programmacion web
para un futuro poder ofrecer una mejor experiencia

## 10. Bibliografía
Aula Virtual del curso


