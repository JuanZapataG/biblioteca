-- Insertar datos en la tabla 'autores'
INSERT INTO autores (id, nombre, nacionalidad, fechaNacimiento) VALUES (1, 'Gabriel García Márquez', 'Colombiana', '1927-03-06');
INSERT INTO autores (id, nombre, nacionalidad, fechaNacimiento) VALUES (2, 'J.K. Rowling', 'Británica', '1965-07-31');

-- Insertar datos en la tabla 'libros'
INSERT INTO libros (id, titulo, isbn, autor_id, pesoNeto, precioBase, editorial) VALUES (1, 'Cien años de soledad', '123456789', 1, 500.0, 20.0, 'Editorial Sudamericana');
INSERT INTO libros (id, titulo, isbn, autor_id, pesoNeto, precioBase, editorial) VALUES (2, 'Harry Potter y la piedra filosofal', '987654321', 2, 300.0, 15.0, 'Bloomsbury');

-- Insertar datos en la tabla 'usuarios'
INSERT INTO usuarios (id, nombre, email, estado) VALUES (1, 'Juan Pérez', 'juan@example.com', 'Activo');
INSERT INTO usuarios (id, nombre, email, estado) VALUES (2, 'Ana López', 'ana@example.com', 'Activo');

-- Insertar datos en la tabla 'prestamos'
INSERT INTO prestamos (id, usuario_id, libro_id, fecha_prestamo, fecha_devolucion) VALUES (1, 1, 1, '2023-01-01', '2023-01-31');
INSERT INTO prestamos (id, usuario_id, libro_id, fecha_prestamo, fecha_devolucion) VALUES (2, 2, 2, '2023-02-01', '2023-02-28');