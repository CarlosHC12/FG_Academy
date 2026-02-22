# 9. Conclusiones

[← Anterior: Manual de Usuario](8_Manual_Usuario.md) | [Volver al índice](../README.md) | [Siguiente: Bibliografía →](10_Bibliografia.md)

---

## 9.1 Análisis DAFO del Proyecto

### Debilidades (Internas)

- **Base de datos H2**: No apta para producción con muchos usuarios concurrentes
- **Autenticación no implementada**: El sistema actual no tiene control de acceso
- **Cobertura de pruebas**: Algunas capas tienen cobertura mejorable
- **Documentación técnica**: Pendiente de completar algunos diagramas
- **Interfaz básica**: Puede mejorarse la experiencia de usuario en móviles

### Amenazas (Externas)

- **Competencia**: Existen wikis consolidadas como Dustloop
- **Cambios tecnológicos**: Actualizaciones de Spring Boot podrían requerir migraciones
- **Seguridad**: Sin autenticación, expuesto a accesos no autorizados
- **Obsolescencia**: Los juegos de lucha tienen ciclos de vida limitados
- **Rendimiento**: H2 puede no escalar bien con muchos datos

### Fortalezas (Internas)

- **Arquitectura hexagonal**: Código mantenible y escalable
- **Internacionalización**: Soporte para 4 idiomas (es, en, ja, ko)
- **Generación de PDF**: Reportes profesionales integrados
- **Filtros avanzados**: Búsqueda eficiente de registros
- **Dockerización**: Fácil despliegue en cualquier entorno
- **Código limpio**: Uso de enums y constantes para rutas

### Oportunidades (Externas)

- **Expansión a más juegos**: Añadir guías de nuevos títulos
- **Versión mobile**: Desarrollo de app nativa o PWA
- **Monetización**: Ofrecer contenido premium o suscripciones
- **API pública**: Abrir endpoints para integraciones externas
- **Modo offline**: Sincronización para usar sin conexión

---

## Matriz DAFO Resumen

| | **FORTALEZAS** | **DEBILIDADES** |
|---|----------------|-----------------|
| **INTERNO** | • Arquitectura hexagonal<br>• 4 idiomas<br>• PDF integrado<br>• Filtros avanzados<br>• Dockerizado | • H2 no escalable<br>• Sin autenticación<br>• Cobertura mejorable<br>• Documentación incompleta |
| **EXTERNO** | **OPORTUNIDADES** | **AMENAZAS** |
| | • Más juegos<br>• App mobile<br>• Comunidad<br>• API pública | • Competencia (Dustloop)<br>• Cambios tecnológicos<br>• Seguridad<br>• Obsolescencia |

---

## Lecciones aprendidas

1. La separación en capas facilita el mantenimiento
2. La internacionalización requiere atención a la codificación UTF-8
3. Las expresiones Thymeleaf deben ir en HTML, no en CSS
4. Flying Saucer requiere HTML bien formado (XHTML)
5. Las pruebas tempranas ahorran tiempo

---

## Próximos pasos

- [ ] Implementar autenticación JWT
- [ ] Añadir más juegos y personajes
- [ ] Mejorar cobertura de pruebas
- [ ] Desplegar en la nube

---

## 9.1 Se realizarán de forma individual

Este proyecto ha sido desarrollado de forma individual por:

| Nombre | Apellido |
|--------|----------|
| [Nombre] | [Apellido] |

---

[← Anterior: Manual de Usuario](8_Manual_Usuario.md) | [Volver al índice](../README.md) | [Siguiente: Bibliografía →](10_Bibliografia.md)
