# Gestión de Tareas - Backend API

Este proyecto es una API RESTful para la gestión de tareas, desarrollada con Java y Spring Boot. Esta API permite realizar operaciones CRUD sobre tareas.

## Requisitos

- Java 8 o superior
- Maven
- (Opcional) MySQL o H2 Database

## Configuración de la Base de Datos

### Usando H2 (Base de Datos en Memoria)

1. H2 se configura por defecto y no requiere configuración adicional. La base de datos H2 se utilizará para pruebas locales y desarrollo rápido.

### Usando MySQL

1. **Instala MySQL**: Asegúrate de tener MySQL instalado y en ejecución.

2. **Crea una Base de Datos**: Crea una base de datos en MySQL llamada `task_db` o cualquier nombre que prefieras.

3. **Configura las Credenciales**: Actualiza el archivo `src/main/resources/application.properties` con tus credenciales de MySQL:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/task_db
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

## Instalación y Ejecución

1. **Clona el Repositorio**

    ```bash
    git clone https://github.com/tu-usuario/tarea-api.git
    cd tarea-api
    ```

2. **Compila el Proyecto**

    Usa Maven para compilar el proyecto:

    ```bash
    mvn clean install
    ```

3. **Ejecuta la Aplicación**

    Ejecuta la aplicación Spring Boot con Maven:

    ```bash
    mvn spring-boot:run
    ```

    La aplicación estará disponible en `http://localhost:9595`.

## Endpoints de la API

- **GET /tasks**: Obtiene todas las tareas.
- **GET /tasks/{id}**: Obtiene una tarea por ID.
- **POST /tasks**: Crea una nueva tarea.
- **PUT /tasks/{id}**: Actualiza una tarea existente.
- **DELETE /tasks/{id}**: Elimina una tarea por ID.

## Documentación de Swagger

La documentación de la API está disponible en Swagger. Accede a la documentación en:http://localhost:9595/swagger-ui.html
alli podras ejecutar cada uno de los endpoints.

## Notas

- **Manejo de Errores**: La API maneja errores y devuelve códigos de estado HTTP adecuados para cada operación.
- **Pruebas**: Se recomienda usar herramientas como Postman para probar los endpoints de la API.


