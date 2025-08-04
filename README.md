# 🍴 Forks: Recipe Manager Backend

A modern Spring Boot backend for the Forks recipe management application. This RESTful API provides comprehensive recipe management, pantry tracking, and user authentication capabilities, built as a learning project to explore Spring Boot and modern backend development practices.

## ✨ Features

- **Recipe Management API**: Full CRUD operations for recipes with ingredients and instructions
- **Pantry Tracking**: Manage ingredient inventory and availability
- **User Management**: User profiles and preferences
- **OAuth2 Authentication**: Secure JWT-based authentication via Keycloak
- **OpenAPI Documentation**: Auto-generated API documentation with Swagger UI
- **Multi-Database Support**: Separate databases for application data and Keycloak
- **Type-Safe Development**: Comprehensive validation and error handling
- **Containerized Development**: Docker Compose setup for easy local development

## 🚀 Tech Stack

### Core Framework
- **Spring Boot 3.5.3** - Modern Spring Boot with latest features
- **Java 21** - Latest LTS Java version
- **Spring Data JPA** - Data persistence layer
- **Spring Security** - Authentication and authorization
- **Spring Boot OAuth2 Resource Server** - JWT token validation

### Database & Migration
- **PostgreSQL 17** - Primary database
- **Flyway** - Database migration management
- **Multi-datasource configuration** - Separate app and Keycloak databases

### Documentation & API
- **SpringDoc OpenAPI** - Automatic API documentation generation
- **Swagger UI** - Interactive API documentation
- **Bean Validation** - Request/response validation

### Development & Testing
- **Spring Boot DevTools** - Hot reload and development utilities
- **TestContainers** - Integration testing with real databases
- **JUnit 5** - Unit and integration testing
- **Spotless + Google Java Format** - Code formatting
- **Spring Boot Actuator** - Application monitoring and health checks

### Authentication
- **Keycloak** - OAuth2/OIDC identity provider
- **JWT** - Stateless authentication tokens

## 📋 Prerequisites

- **Java 21+** and Gradle
- **Docker & Docker Compose** - For databases and Keycloak
- **PostgreSQL** (via Docker)
- **Keycloak server** (via Docker)

## 🛠️ Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd forks_backend
   ```

2. **Start the infrastructure services**
   ```bash
   docker compose up -d
   ```
   This will start:
   - PostgreSQL for application data (port 14093)
   - PostgreSQL for Keycloak (port 14092)
   - Keycloak server (port 14082)

3. **Configure Keycloak**
   - Access Keycloak admin console at `http://localhost:14082`
   - Login with `keycloak/keycloak`
   - Create a new realm called "Forks"
   - Configure your client and users as needed

4. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

The API will be available at `http://localhost:1291`

## 📁 Project Structure

```
src/main/java/com/svoglimacci/forks_backend/
├── ForksBackendApplication.java    # Main application class
├── config/
│   └── CorsConfig.java            # CORS configuration
├── configs/
│   ├── DatabaseConfig.java       # Multi-datasource configuration
│   └── SecurityConfig.java       # Security and OAuth2 setup
├── controllers/                   # REST API endpoints
│   ├── IngredientController.java
│   ├── PantryController.java
│   ├── RecipeController.java
│   └── UserController.java
├── dtos/                         # Data Transfer Objects
│   ├── IngredientDTO.java
│   ├── PantryDTO.java
│   ├── RecipeDTO.java
│   └── UserDTO.java
├── entities/                     # JPA entities
│   ├── IngredientEntity.java
│   └── ...
├── exceptions/                   # Custom exception handling
├── mappers/                      # Entity-DTO mapping
├── repositories/                 # Data access layer
├── services/                     # Business logic layer
└── utils/                        # Utility classes

src/main/resources/
├── application.properties        # Application configuration
├── db/migration/                # Flyway migration scripts
├── static/                      # Static web assets
└── templates/                   # Template files
```

## 🔧 Configuration

### Database Configuration

The application uses two separate PostgreSQL databases:

- **Application Database** (port 14093): Stores recipes, ingredients, pantry data, and user information
- **Keycloak Database** (port 14092): Stores Keycloak authentication data

### Key Configuration Properties

```properties
# Server Configuration
server.port=1291

# Application Database
app.datasource.backend.url=jdbc:postgresql://localhost:14093/postgres
app.datasource.backend.username=postgres
app.datasource.backend.password=postgres

# Keycloak Database
app.datasource.keycloak.url=jdbc:postgresql://localhost:14092/keycloak
app.datasource.keycloak.username=keycloak
app.datasource.keycloak.password=keycloak

# OAuth2 Configuration
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:14082/realms/Forks
```

## 📡 API Documentation

- **Swagger UI**: `http://localhost:1291/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:1291/v3/api-docs`
- **Health Check**: `http://localhost:1291/actuator/health`

### Available Endpoints

- **Recipes**: `/recipes` - Create, read, update, delete recipes
- **Ingredients**: `/ingredients` - Manage ingredient catalog
- **Pantry**: `/pantry` - Track ingredient inventory
- **Users**: `/users` - User profile management

## 🔐 Authentication & Security

The application implements OAuth2 resource server pattern:

1. **JWT Token Validation**: All API endpoints (except public ones) require valid JWT tokens
2. **Keycloak Integration**: Tokens are issued by Keycloak and validated by the application
3. **Role-Based Access**: Future enhancement for role-based authorization
4. **CORS Configuration**: Configured for frontend integration

### Security Features

- Stateless authentication with JWT
- Token validation against Keycloak
- HTTPS ready configuration
- Request validation and sanitization

## 🧪 Testing

```bash
# Run all tests
./gradlew test

# Run with TestContainers (integration tests)
./gradlew test --tests "*IntegrationTest"

# Generate test report
./gradlew test jacocoTestReport
```

The project uses TestContainers for integration testing, ensuring tests run against real PostgreSQL databases.

## 🚀 Available Scripts

```bash
# Development
./gradlew bootRun              # Start the application
./gradlew bootRun --args="--spring.profiles.active=dev"

# Building
./gradlew build                # Build the application
./gradlew clean build          # Clean and build

# Code Quality
./gradlew spotlessApply        # Format code
./gradlew spotlessCheck        # Check code formatting

# Testing
./gradlew test                 # Run tests
./gradlew integrationTest      # Run integration tests

# Docker
docker compose up -d           # Start infrastructure
docker compose down            # Stop infrastructure
```

## 🏗️ Database Migration

The application uses Flyway for database migrations:

1. Create migration files in `src/main/resources/db/migration/`
2. Follow naming convention: `V{version}__{description}.sql`
3. Migrations run automatically on application startup

Example migration file: `V1__Create_recipe_table.sql`

## 🔄 Development Workflow

1. **Infrastructure**: Start databases and Keycloak with Docker Compose
2. **Code Changes**: Make changes with hot reload via Spring Boot DevTools
3. **API Testing**: Use Swagger UI for interactive API testing
4. **Code Formatting**: Automatic formatting with Spotless
5. **Testing**: Comprehensive test suite with TestContainers

## 🌐 Frontend Integration

This backend is designed to work with the [Forks Frontend](https://github.com/svoglimacci/forks_frontend):

- **OpenAPI Specification**: Provides schema for automatic client generation
- **CORS Configuration**: Allows frontend requests
- **JWT Authentication**: Stateless authentication for SPA
- **RESTful API**: Standard REST endpoints for all operations

## 📚 Learning Goals

This backend project explores:

- **Spring Boot 3.x**: Latest Spring Boot features and patterns
- **OAuth2 Resource Server**: Modern authentication patterns
- **Multi-Database Configuration**: Complex datasource management
- **OpenAPI Documentation**: Automatic API documentation
- **TestContainers**: Modern integration testing
- **Docker Compose**: Development environment management
- **Code Quality**: Formatting, linting, and best practices


## 📄 License

This project is for educational purposes.
