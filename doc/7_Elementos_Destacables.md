# 7. Elementos destacables del desarrollo

[← Anterior: Herramientas](6_Herramientas.md) | [Volver al índice](../README.md) | [Siguiente: Manual de Usuario →](8_Manual_Usuario.md)

---

## Innovaciones

- **Arquitectura hexagonal**: Separación clara entre capas
- **Internacionalización**: Soporte para 4 idiomas
- **Generación de PDF**: Reportes profesionales con Flying Saucer
- **Filtros en tiempo real**: Búsqueda sin recargar página
- **Diseño responsive**: Adaptable a dispositivos móviles

---

## Cosas desarrolladas no vistas en clase

- **DevContainer**: Entorno de desarrollo reproducible
- **Internacionalización completa**: Archivos de propiedades para 4 idiomas
- **Generación de PDF con estilos**: Uso de Flying Saucer con CSS
- **Filtros avanzados**: Búsqueda por múltiples criterios
- **Modales de confirmación**: Para acciones destructivas

---

## Problemas encontrados y soluciones

| Problema | Solución |
|----------|----------|
| Error de Thymeleaf en CSS | Separar expresiones del CSS |
| Fechas en PDF | Usar #temporals en lugar de #dates |
| Internacionalización no funcionaba | Archivos .properties en UTF-8 |
| Error { expected en CSS | Quitar expresiones Thymeleaf del CSS |
| Botones duplicados | Refactorizar con enums y constantes |

---

[← Anterior: Herramientas](6_Herramientas.md) | [Volver al índice](../README.md) | [Siguiente: Manual de Usuario →](8_Manual_Usuario.md)