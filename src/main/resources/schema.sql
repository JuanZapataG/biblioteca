CREATE TABLE IF NOT EXISTS autores (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    nacionalidad VARCHAR(255),
    fechanacimiento VARCHAR(255),
    fechadefuncion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS libros (
    id INT PRIMARY KEY,
    titulo VARCHAR(255),
    isbn VARCHAR(255),
    autor_id INT,
    pesoNeto DOUBLE,
    precioBase DOUBLE,
    editorial VARCHAR(255),
    FOREIGN KEY (autor_id) REFERENCES autores(id)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255),
    estado VARCHAR(255),
    fechanacimiento VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS prestamos (
    id INT PRIMARY KEY,
    usuario_id INT,
    libro_id INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (libro_id) REFERENCES libros(id)
);