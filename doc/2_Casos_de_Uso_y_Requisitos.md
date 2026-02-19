# Casos de Uso y Requisitos

## Página de Inicio Pública
- **Descripción:** La página de inicio es accesible para todos los usuarios, sin restricciones.

## Casos de Uso: Gestión de Usuarios

### 1. Iniciar Sesión
- **Actor:** Usuario (Estudiante, Profesor)
- **Descripción:** Los usuarios pueden iniciar sesión para acceder a las listas de estudiantes y profesores.

### 2. Ver Listas de Estudiantes y Profesores
- **Actor:** Estudiante, Profesor
- **Descripción:** Los usuarios pueden ver las listas de estudiantes y profesores, pero no pueden editarlas.

### 3. Gestión de Usuarios por Administrador
- **Actor:** Administrador
- **Flujo Principal:**
    1. El administrador inicia sesión.
    2. El administrador accede a las listas de estudiantes y profesores.
    3. El administrador puede:
        - Editar o eliminar un estudiante o profesor existente.
        - Crear nuevos estudiantes o profesores utilizando formularios.
        - Descargar listas en formato PDF.

## Requisitos Funcionales
1. El sistema debe permitir a los usuarios iniciar sesión.
2. El sistema debe ofrecer vistas de listas de estudiantes y profesores a los usuarios (lectura únicamente).
3. El administrador debe poder gestionar estudiantes y profesores (editar, eliminar, crear).
4. El sistema debe permitir la descarga de listas como archivos PDF.

## Requisitos No Funcionales
1. **Usabilidad:** La interfaz debe ser intuitiva y fácil de navegar.
2. **Seguridad:** El sistema debe asegurar que solo los administradores puedan realizar cambios en los datos.
3. **Rendimiento:** Las listas deben cargarse rápidamente, incluso con un gran número de registros.
4. **Compatibilidad:** El sistema debe ser accesible desde diferentes dispositivos y navegadores.