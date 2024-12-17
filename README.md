# Book App for Authors and Readers

This Spring Boot-based Book App is designed for authors, readers, and administrators. It supports functionalities where:

- **Readers** can view books and add favorite books.
- **Authors** can add new books.
- **Admins** have full access to manage the application.

### Features

- **Registration & Login**: Users can register, log in, and receive a JWT token for authentication and authorization.
- **Book Management**:
    - Readers can view available books and add books to their favorites.
    - Authors can add new books to the system.
- **Admin Role**: Admins have full control, including the ability to manage users and books.
- **Password Management**: Users can change their password after registration.

### Technologies Used

- **Spring Boot**: Backend framework for building the application.
- **Spring Security**: Authentication and authorization mechanism.
- **Docker**: Containerization for easy deployment.
- **Swagger**: API documentation and testing interface.
- **PostgreSQL**: Remote database to store book and user data in Render.
- **Render**: Deployment platform.

### Installation

#### Run from Docker

To run the application using Docker, follow these steps:

1. Pull the Docker image from Docker Hub:
   ```bash
   docker pull azizeyvazov02/book-app:latest

2. Run the application in a Docker container:
   ```bash
    docker run -p 8080:8080 azizeyvazov02/book-app:latest

The app will be accessible at http://localhost:8080.

### Swagger UI
You can test the API using Swagger by navigating to the following URL after starting the application:

https://bookapp-tf5b.onrender.com/swagger-ui/index.html#/  or  http://localhost:8080/swagger-ui/index.html#/