INSERT INTO PROFESORES (id, nombre) VALUES 
(1, 'Carlos Rodríguez'),      
(2, 'Ana Martínez'),         
(3, 'Luis Fernández'),       
(4, 'Marta Sánchez'),       
(5, 'Javier Gómez');         

INSERT INTO ALUMNOS (nombre, edad, fecha_creacion, profesor_id) VALUES 
('Alejandro Pérez', 22, NOW(), 1),
('Beatriz Gómez', 20, NOW(), 1),
('Carlos López', 23, NOW(), 1),
('Daniela García', 21, NOW(), 1),

('Elena Ruiz', 19, NOW(), 2),
('Francisco Díaz', 24, NOW(), 2),
('Gabriela Torres', 22, NOW(), 2),
('Héctor Jiménez', 20, NOW(), 2),

('Irene Moreno', 25, NOW(), 3),
('Javier Álvarez', 21, NOW(), 3),
('Laura Martín', 22, NOW(), 3),
('Manuel Romero', 23, NOW(), 3),

('Nuria Vázquez', 20, NOW(), 4),
('Óscar Muñoz', 24, NOW(), 4),
('Paula Calvo', 19, NOW(), 4),
('Raúl Reyes', 22, NOW(), 4),

('Sara Ortiz', 21, NOW(), 5),
('Tomás Herrera', 23, NOW(), 5),
('Úrsula Iglesias', 20, NOW(), 5),
('Víctor Serrano', 22, NOW(), 5);