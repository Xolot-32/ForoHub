# ForoHub

ForoHub es una API RESTful para la gestión de un foro de discusión, desarrollada con Spring Boot. Esta API permite a los usuarios crear, leer, actualizar y eliminar tópicos de discusión, así como autenticarse de forma segura utilizando JWT (JSON Web Tokens).

## Características principales

- CRUD completo para tópicos de discusión
- Autenticación de usuarios mediante JWT
- Validación de datos de entrada
- Manejo de errores y excepciones
- Seguridad con Spring Security

## Requisitos previos

- Java JDK 17 o superior
- Maven 4.0 o superior
- MySQL 8.0 o superior

## Configuración del proyecto

1. Clona el repositorio:
   ```
   git clone https://github.com/tu-usuario/forohub.git
   cd forohub
   ```

2. Configura la base de datos MySQL:
   - Crea una base de datos llamada `forohub`
   - Actualiza las credenciales de la base de datos en `src/main/resources/application.properties`

3. Ejecuta las migraciones de la base de datos:
   ```
   mvn flyway:migrate
   ```

4. Compila y ejecuta el proyecto:
   ```
   mvn spring-boot:run
   ```

La API estará disponible en `http://localhost:8080`

## Endpoints principales

- `POST /login`: Autenticar usuario y obtener token JWT
- `POST /topicos`: Crear un nuevo tópico
- `GET /topicos`: Listar todos los tópicos
- `GET /topicos/{id}`: Obtener detalles de un tópico específico
- `PUT /topicos/{id}`: Actualizar un tópico existente
- `DELETE /topicos/{id}`: Eliminar un tópico

## Seguridad

Todos los endpoints, excepto `/login`, requieren autenticación. Para acceder a estos endpoints, incluye el token JWT en el encabezado de la solicitud:

```
Authorization: Bearer <tu-token-jwt>
```

## Tecnologías utilizadas

- Spring Boot 3.1.0
- Spring Security
- Spring Data JPA
- Flyway
- MySQL
- Lombok
- JSON Web Token (JWT)

## Contribuir

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir los cambios propuestos antes de realizar un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
