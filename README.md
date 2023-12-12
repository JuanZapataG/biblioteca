# Sistema de Gestión de Biblioteca
Este proyecto es un sistema de gestión de biblioteca desarrollado con Spring Boot y Reactor, utilizando una base de datos en memoria H2 y R2DBC para la persistencia de datos. El sistema permite la gestión de autores, libros, usuarios y préstamos de libros.
# Endpoints
GET /autores: Obtiene todos los autores.

GET /autores/{id}: Obtiene un autor por su id.

POST /autores: Crea un nuevo autor.

PUT /autores/{id}: Actualiza un autor por su id.

DELETE /autores/{id}: Elimina un autor por su id.

GET /libros: Obtiene todos los libros.

GET /libros/{id}: Obtiene un libro por su id.

GET /usuarios: Obtiene todos los usuarios.

GET /usuarios/{id}: Obtiene un usuario por su id.

GET /prestamos: Obtiene todos los préstamos.

GET /prestamos/{id}: Obtiene un préstamo por su id.

# Tecnologías Utilizadas
Spring Boot: Para la creación del proyecto y configuración del entorno.

Spring Data R2DBC: Para la conexión reactiva con la base de datos.

H2 Database: Como base de datos en memoria.

Lombok: Para reducir el código repetitivo en las entidades.

JUnit y Mockito: Para pruebas unitarias.

Reactor Test: Para pruebas de los flujos reactivos.