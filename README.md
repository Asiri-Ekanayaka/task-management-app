# Task Management System

The Task Management System is a Spring Boot application that provides a RESTful API for managing tasks and user authentication. It uses a MySQL database and supports user sign-up, sign-in, and basic task operations such as creating, updating, deleting, and retrieving tasks.

## Features

- **User Management:** Users can sign up and sign in to the system.
- **Task Management:** Create, update, delete, and retrieve tasks.
- **JWT Authentication:** Secure user authentication and token generation.
- **Docker Support:** The project includes a `Dockerfile` and `docker-compose.yml` for easy setup with Docker.
- **MySQL Database:** Uses MySQL for data storage with HikariCP connection pooling.

## Technologies Used

- Java 21
- Spring Boot
- MySQL
- Maven
- Docker
- Hibernate JPA
- HikariCP
- JWT (JSON Web Token) for authentication

## Getting Started

### Prerequisites

- [Docker](https://www.docker.com/)
- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Maven](https://maven.apache.org/)

### Running the Application

You can run the application using Docker. Follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Asiri-Ekanayaka/task-management-app.git
   cd task-management-app

2. Build and run the containers using Docker Compose:
   ```bash
   docker compose up

3. The API will be available at http://localhost:8080.

## API Endpoints
### User Management

- POST /sign-up: Register a new user.
- POST /sign-in: Authenticate a user and retrieve a JWT token.

### Task Management

- `POST /api/v1/tasks`: Create a new task.
- `PATCH /api/v1/tasks/{taskId}`: Update an existing task.
- `DELETE /api/v1/tasks/{taskId}`: Delete a task.
- `GET /api/v1/tasks`: Retrieve all tasks.

## Configuration

The application configuration is defined in `application.yml`:

- Database Configuration: Uses a MySQL database. The connection settings can be customized in the `spring.datasource` section.
- Logging Configuration: Logs are saved to `app.log`.

## Docker Configuration

- `Dockerfile`: Builds the Java application.
- `docker-compose.yml`: Sets up the API and MySQL services.
- Volumes: A Docker volume named `task-app-data` is used to persist MySQL data.

## Running Tests
   ```bash
      mvn test 
   ```
        
         
   
## License 

This project is licensed under the [MIT License](LICENSE.txt).

## Contributing
Contributions are welcome. Please open a pull request or an issue to discuss changes.

## Repository
The source code is available at [GitHub - Asiri-Ekanayaka/task-management-app](https://github.com/Asiri-Ekanayaka/task-management-app).