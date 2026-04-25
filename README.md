# Elifoot

> **Work In Progress** - This project is currently under active development.

Elifoot is a Java application built with Spring Boot that simulates the management of soccer clubs, including features such as the registration of stadiums, players, and clubs; authentication and authorization using OAuth2; and permission control via scopes.

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.x |
| Database | PostgreSQL |
| Migrations | Flyway |
| ORM | Spring Data JPA / Hibernate |
| Mapping | MapStruct |
| API Docs | springdoc-openapi (Swagger UI) |
| Build | Maven |

## Requirements

- Java 17+
- PostgreSQL
- Maven 3.8+

## Configuration

The application reads its configuration from environment variables. Create a `.env` file or export the following variables before running:

```bash
DB_URL=jdbc:postgresql://localhost:5432/elifoot
DB_USERNAME=your_user
DB_PASSWORD=your_password
```

JWT authentication requires RSA key files placed under `src/main/resources/`:

- `authz.pub` — RSA public key
- `authz.pem` — RSA private key

## Running the application

```bash
mvn spring-boot:run
```

## API Documentation

After the application is running, the interactive Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

The raw OpenAPI 3 spec is available at:

```
http://localhost:8080/v3/api-docs
```

## Endpoints

### Stadiums — `/api/stadiums`

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/stadiums` | Register a new stadium |
| `GET` | `/api/stadiums` | List all stadiums (paginated) |

### Clubs — `/api/clubs`

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/clubs` | Register a new club |
| `GET` | `/api/clubs` | List all clubs (paginated) |
| `GET` | `/api/clubs/{id}` | Get club details by ID |

### Players — `/api/players`

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/api/players` | Register a new player |
| `GET` | `/api/players` | List all players (paginated) |
| `GET` | `/api/players/{id}` | Get player details by ID |

## Project Structure

```
src/main/java/dev/vinicius/elifoot/
├── controller/         # REST controllers and request/response DTOs
├── entity/             # JPA entities (Club, Stadium, Player)
├── mapper/             # MapStruct mappers
├── repository/         # Spring Data JPA repositories
├── service/            # Business logic services
└── expection/          # Custom exception classes
```

## Database Migrations

Flyway migrations are located in `src/main/resources/db/migration/` and run automatically on startup.
