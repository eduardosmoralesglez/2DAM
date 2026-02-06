-- Datos de ejemplo (H2)
-- Nota: H2 permite insertar valores explícitos en columnas IDENTITY.

INSERT INTO SOCIO (id, nombre, email, fecha_alta) VALUES
  (1, 'Ana López', 'ana.lopez@example.com', DATE '2024-09-01'),
  (2, 'Juan Pérez', 'juan.perez@example.com', DATE '2024-10-15');

INSERT INTO LIBRO (id, isbn, titulo, autor, anio) VALUES
  (1, '9788497592208', 'El Quijote', 'Miguel de Cervantes', 1605),
  (2, '9788401352836', 'La sombra del viento', 'Carlos Ruiz Zafón', 2001),
  (3, '9780307474278', '1984', 'George Orwell', 1949);

-- Préstamos: libro 1 activo (socio 1) y libro 2 devuelto (socio 2)
INSERT INTO PRESTAMO_LIBRO (id, socio_id, libro_id, fecha_inicio, fecha_fin, estado) VALUES
  (1, 1, 1, DATE '2025-01-10', NULL, 'ACTIVO'),
  (2, 2, 2, DATE '2024-12-01', DATE '2024-12-20', 'DEVUELTO');
